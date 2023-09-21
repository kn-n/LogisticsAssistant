package ru.kn_n.tasks.presentation

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import ru.kn_n.core.base.BaseFragment
import ru.kn_n.tasks.databinding.FragmentIncidentBinding
import ru.kn_n.tasks.presentation.viewModel.IncidentViewModel
import javax.inject.Inject

class IncidentFragment : BaseFragment<FragmentIncidentBinding>(FragmentIncidentBinding::inflate) {
    @Inject
    lateinit var viewModel: IncidentViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory)[IncidentViewModel::class.java]
    }
}