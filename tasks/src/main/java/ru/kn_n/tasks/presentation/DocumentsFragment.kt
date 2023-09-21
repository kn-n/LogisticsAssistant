package ru.kn_n.tasks.presentation

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import ru.kn_n.core.base.BaseFragment
import ru.kn_n.core.base.ViewModelFactory
import ru.kn_n.tasks.databinding.FragmentDocumentsBinding
import ru.kn_n.tasks.presentation.viewModel.DocumentsViewModel
import javax.inject.Inject

class DocumentsFragment:BaseFragment<FragmentDocumentsBinding>(FragmentDocumentsBinding::inflate) {

    @Inject
    lateinit var viewModel: DocumentsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory)[DocumentsViewModel::class.java]
    }
}