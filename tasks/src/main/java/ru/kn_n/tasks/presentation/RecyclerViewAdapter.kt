package ru.kn_n.tasks.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.load.engine.Resource
import ru.kn_n.core.base.UserIdCache
import ru.kn_n.core.utils.EMPTY
import ru.kn_n.core.utils.gone
import ru.kn_n.core.utils.isShow
import ru.kn_n.core.utils.show
import ru.kn_n.tasks.R
import ru.kn_n.tasks.databinding.ItemTaskBinding
import ru.kn_n.tasks.domain.StatusJob
import ru.kn_n.tasks.domain.TaskEntity
import javax.inject.Inject

class RecyclerViewAdapter (
    val onTaskClick: (id: String) -> Unit
) : RecyclerView.Adapter<RecyclerViewAdapter.TaskItemsViewHolder>() {

    private val items = ArrayList<TaskEntity>()
    private var userId = String.EMPTY

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskItemsViewHolder {
        val binding = ItemTaskBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TaskItemsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskItemsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class TaskItemsViewHolder(
        private val binding: ItemTaskBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: TaskEntity) {
            with(binding) {
                name.text = data.cargoType
                date.text = data.date
                time.text = data.time
                addressFrom.text = data.startPoint
                addressTo.text = data.endPoint
                offerDetails.text = data.offerDetails
                paymentOptions.text = data.paymentOptions

                btnDetails.setOnClickListener {
                    onTaskClick.invoke(data.id)
                }
                with(data.status) {
                    statusTitle.text = title
                    statusSubtitle.text = subtitle
                    when (this) {
                        StatusJob.NONE -> {
                            statusBlock.gone()
                            detailsBlock.show()
                            btnDetails.show()
                            status.isShow(data.idPerformer == userId)
                        }
                        StatusJob.DONE -> {
                            statusTitle.isEnabled=true
                            detailsBlock.gone()
                            btnDetails.gone()
                            statusBlock.show()
                        }
                        StatusJob.WAITING -> {
                            statusTitle.isEnabled=true
                            detailsBlock.show()
                            btnDetails.show()
                            statusBlock.show()
                            status.gone()
                        }
                        StatusJob.DECLINE -> {
                            statusTitle.isEnabled=false
                            detailsBlock.gone()
                            btnDetails.gone()
                            statusBlock.show()
                            status.gone()
                        }
                        StatusJob.NOT_RELEVANT -> {
                            statusTitle.isEnabled=false
                            detailsBlock.gone()
                            btnDetails.gone()
                            statusBlock.show()
                        }
                    }
                }
            }
        }
    }

    fun setItems(data: List<TaskEntity>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }
    fun setUserId(data: String) {
        userId = String.EMPTY
        userId = data
        notifyDataSetChanged()
    }
}