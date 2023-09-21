package ru.kn_n.tasks.presentation

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import ru.kn_n.core.base.BaseFragment
import ru.kn_n.tasks.databinding.FragmentTaskDetailsBinding
import ru.kn_n.tasks.domain.TaskEntity
import ru.kn_n.tasks.presentation.viewModel.TaskDetailsViewModel
import javax.inject.Inject

class TaskDetailsFragment :
    BaseFragment<FragmentTaskDetailsBinding>(FragmentTaskDetailsBinding::inflate) {

    @Inject
    lateinit var viewModel: TaskDetailsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
        setupButtons()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory)[TaskDetailsViewModel::class.java]
    }

    private fun setupButtons() {
        with(binding) {
            btnDownload.setOnClickListener {

            }
            btnAccept.setOnClickListener {

            }
            btnDecline.setOnClickListener {

            }
            btnIncident.setOnClickListener {

            }
            btnError.setOnClickListener {

            }
            btnAttachDocuments.setOnClickListener {

            }
        }
    }

    private fun showData(profile: TaskEntity) {
        with(binding) {
            cargoType.text = profile.cargoType
            performersCity.text = profile.performersCity
            orderDate.text = profile.date
            arrivalTime.text = profile.date
            startPoint.text = profile.startPoint
            endPoint.text = profile.endPoint
            bodyType.text = profile.bodyType
            offerDetails.text = profile.offerDetails
            paymentOptions.text = profile.paymentOptions
            contactPhone.text = profile.contactPhone
            contactName.text = profile.contactName
        }
    }
}