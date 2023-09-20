package ru.kn_n.tasks.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.kn_n.core.utils.show
import ru.kn_n.tasks.databinding.ItemTaskBinding
import ru.kn_n.tasks.domain.StatusJob
import ru.kn_n.tasks.domain.TaskEntity

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.TaskItemsViewHolder>() {

    private val items = ArrayList<TaskEntity>()

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

                if (data.status != StatusJob.NONE) {
                    statusTitle.text = data.status.title
                    statusSubtitle.text = data.status.subtitle
                    statusBlock.show()
                }
            }
        }
    }

    fun setItems(data: List<TaskEntity>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }
}