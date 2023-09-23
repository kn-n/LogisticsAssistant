package ru.kn_n.logisticsassistant.presentation.fragment

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.kn_n.core.base.BaseFragment
import ru.kn_n.core.utils.EMPTY
import ru.kn_n.core.utils.gone
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

        with(activity as AppCompatActivity){
            supportActionBar?.setDisplayUseLogoEnabled(true)
            supportActionBar?.title = String.EMPTY
            findViewById<BottomNavigationView>(R.id.bottom_navigation).gone()
        }
        super.onViewCreated(view, savedInstanceState)

        setupViewModule()

        binding.phoneBlock.show()
        binding.codeBlock.gone()

        binding.btnContinue.setOnClickListener {
            if (binding.phoneBlock.visibility == View.VISIBLE) {
                viewModel.startPhoneNumberVerification(
                    binding.inputPhone.editText?.text.toString(),
                    requireActivity()
                )
                binding.phoneBlock.gone()
                binding.codeBlock.show()
            } else if (binding.codeBlock.visibility == View.VISIBLE) {
                verify()
            }
        }
    }

    private fun verify() {
        viewModel.verifyPhoneNumberWithCode(binding.inputCode.editText?.text.toString())
        viewModel.resultAuth.observe(viewLifecycleOwner) {
            goToApp()
        }
    }

    private fun goToApp() {
        (activity as AppCompatActivity).supportActionBar?.setDisplayUseLogoEnabled(false)
        (activity as AppCompatActivity).findViewById<BottomNavigationView>(R.id.bottom_navigation)
            .show()
        findNavController().navigate(R.id.action_authorizationFragment_to_nav_main)
    }

    private fun setupViewModule() {
        viewModel = ViewModelProvider(this, viewModelFactory)[AuthorizationViewModel::class.java]
    }

}