package ru.kn_n.tasks.presentation

import android.os.Bundle
import android.view.View
import ru.kn_n.core.base.BaseFragment
import ru.kn_n.navigationapi.NavigationApi
import ru.kn_n.tasks.databinding.FragmentTaskDetailsBinding
import ru.kn_n.tasks.domain.TaskEntity
import ru.kn_n.tasks.navigation.TaskDetailsDirections
import javax.inject.Inject

class TaskDetailsFragment: BaseFragment<FragmentTaskDetailsBinding>(FragmentTaskDetailsBinding::inflate) {

    @Inject
    lateinit var navigationApi: NavigationApi<TaskDetailsDirections>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupButtons()
    }

    private fun setupButtons(){
        with(binding){
            btnDownload.setOnClickListener {

            }
            btnAccept.setOnClickListener {

            }
            btnDecline.setOnClickListener {

            }
            btnIncident.setOnClickListener {
                navigationApi.navigate(TaskDetailsDirections.ToIncident)
            }
            btnError.setOnClickListener {
                navigationApi.navigate(TaskDetailsDirections.ToError)
            }
            btnAttachDocuments.setOnClickListener {
                navigationApi.navigate(TaskDetailsDirections.ToAttachDocuments)
            }
        }
    }

    private fun showData(profile: TaskEntity) {
        with(binding){
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