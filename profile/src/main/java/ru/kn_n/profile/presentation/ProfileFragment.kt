package ru.kn_n.profile.presentation

import android.os.Bundle
import android.view.View
import ru.kn_n.core.base.BaseFragment
import ru.kn_n.core.utils.loadImage
import ru.kn_n.navigationapi.NavigationApi
import ru.kn_n.profile.databinding.FragmentProfileBinding
import ru.kn_n.profile.domain.ProfileEntity
import ru.kn_n.profile.navigation.ProfileDirections
import javax.inject.Inject

class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    @Inject
    lateinit var navigationApi: NavigationApi<ProfileDirections>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupButtons()
    }

    private fun setupButtons(){
        with(binding){
            btnSickLeave.setOnClickListener {

            }
            btnLogOut.setOnClickListener {
                navigationApi.navigate(ProfileDirections.ToAuthorization)
            }
            btnNotifications.setOnClickListener {

            }
        }
    }

    private fun showData(profile: ProfileEntity) {
        with(binding){
            loadImage(profileImage, profile.imgUrl, profileImage)
            name.text = profile.name
            post.text = profile.post
            serviceNumber.text = profile.serviceNumber
            phone.text = profile.phone
            citizenship.text = profile.citizenship
            carType.text = profile.carType
            carNumber.text = profile.carNumber
        }
    }
}