package ru.kn_n.profile.presentation

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import ru.kn_n.core.base.BaseFragment
import ru.kn_n.core.utils.loadImage
import ru.kn_n.profile.databinding.FragmentProfileBinding
import ru.kn_n.profile.domain.ProfileEntity
import javax.inject.Inject

class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    @Inject
    lateinit var viewModel: ProfileViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
        setupButtons()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory)[ProfileViewModel::class.java]
    }

    private fun setupButtons() {
        with(binding) {
            btnSickLeave.setOnClickListener {

            }
            btnLogOut.setOnClickListener {

            }
            btnNotifications.setOnClickListener {

            }
        }
    }

    private fun showData(profile: ProfileEntity) {
        with(binding) {
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