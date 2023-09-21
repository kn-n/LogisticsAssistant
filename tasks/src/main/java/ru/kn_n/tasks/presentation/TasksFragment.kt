package ru.kn_n.tasks.presentation

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import ru.kn_n.core.base.BaseFragment
import ru.kn_n.tasks.databinding.FragmentTasksBinding
import ru.kn_n.tasks.presentation.viewModel.TasksViewModel
import javax.inject.Inject

class TasksFragment : BaseFragment<FragmentTasksBinding>(FragmentTasksBinding::inflate) {
    @Inject
    lateinit var viewModel: TasksViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory)[TasksViewModel::class.java]
    }
}