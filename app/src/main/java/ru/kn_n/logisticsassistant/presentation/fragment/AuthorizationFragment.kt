package ru.kn_n.logisticsassistant.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.kn_n.core.base.BaseFragment
import ru.kn_n.core.utils.show
import ru.kn_n.logisticsassistant.R
import ru.kn_n.logisticsassistant.databinding.FragmentAuthorizationBinding
import ru.kn_n.logisticsassistant.presentation.viewModel.AuthorizationViewModel
import javax.inject.Inject

class AuthorizationFragment :
    BaseFragment<FragmentAuthorizationBinding>(FragmentAuthorizationBinding::inflate) {

    @Inject
    lateinit var viewModel: AuthorizationViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnContinue.setOnClickListener {
            (activity as AppCompatActivity).supportActionBar?.setDisplayUseLogoEnabled(false)
            (activity as AppCompatActivity).findViewById<BottomNavigationView>(R.id.bottom_navigation).show()
            findNavController().navigate(R.id.action_authorizationFragment_to_nav_main)
        }
        setupViewModule()
    }

    private fun setupViewModule() {
        viewModel = ViewModelProvider(this, viewModelFactory)[AuthorizationViewModel::class.java]
    }

}