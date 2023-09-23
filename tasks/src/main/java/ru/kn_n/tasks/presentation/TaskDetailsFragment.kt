package ru.kn_n.tasks.presentation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ru.kn_n.core.base.BaseFragment
import ru.kn_n.core.utils.EMPTY
import ru.kn_n.core.utils.isShow
import ru.kn_n.core.utils.showInfoAlertDialog
import ru.kn_n.tasks.R
import ru.kn_n.tasks.databinding.FragmentTaskDetailsBinding
import ru.kn_n.tasks.domain.StatusJob
import ru.kn_n.tasks.domain.TaskEntity
import ru.kn_n.tasks.presentation.viewModel.TaskDetailsViewModel
import javax.inject.Inject

class TaskDetailsFragment :
    BaseFragment<FragmentTaskDetailsBinding>(FragmentTaskDetailsBinding::inflate) {

    @Inject
    lateinit var viewModel: TaskDetailsViewModel

    private var task = TaskEntity()

    private val bundle = Bundle()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()

        val id = arguments?.getString("ID")


        bundle.putString("ID", id)

        if (id != null) {
            getData(id)
        } else {
            showInfoAlertDialog(
                getString(ru.kn_n.core.R.string.info_title),
                getString(ru.kn_n.core.R.string.info_message)
            )
        }

        setupButtons()
    }

    private fun getData(id: String) {
        viewModel.getTaskDetails(id)
        viewModel.resultTaskDetails.observe(viewLifecycleOwner) {
            task = it
            showData(task)
        }
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory)[TaskDetailsViewModel::class.java]
    }

    private fun setupButtons() {
        with(binding) {
            btnDownload.setOnClickListener {
                val openPage = Intent(Intent.ACTION_VIEW, Uri.parse(task.rules))
                startActivity(openPage)
            }
            btnAccept.setOnClickListener {
            }
            btnDecline.setOnClickListener {
            }
            btnIncident.setOnClickListener {
                findNavController().navigate(R.id.action_taskDetailsFragment_to_incidentFragment, bundle)
            }
            btnError.setOnClickListener {
            }
            btnAttachDocuments.setOnClickListener {
                findNavController().navigate(R.id.action_taskDetailsFragment_to_documentsFragment, bundle)
            }
            btnRefuseTask.setOnClickListener {
            }
        }
    }

    private fun showData(task: TaskEntity) {
        with(binding) {
            cargoType.text = task.cargoType
            performersCity.text = task.performersCity
            orderDate.text = task.date
            arrivalTime.text = task.date
            startPoint.text = task.startPoint
            endPoint.text = task.endPoint
            bodyType.text = task.bodyType
            offerDetails.text = task.offerDetails
            paymentOptions.text = task.paymentOptions
            contactPhone.text = task.contactPhone
            contactName.text = task.contactName

            btnIncident.isShow(task.idPerformer.isNotEmpty())
            btnError.isShow(task.idPerformer.isNotEmpty())
            btnAttachDocuments.isShow(task.idPerformer.isNotEmpty())
            btnRefuseTask.isShow(task.idPerformer.isNotEmpty())
            info.isShow(task.idPerformer.isNotEmpty())
            btnAccept.isShow(task.idPerformer.isEmpty())
            btnDecline.isShow(task.idPerformer.isEmpty())
        }
    }
}