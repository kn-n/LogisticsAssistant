package ru.kn_n.tasks.presentation

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ru.kn_n.core.base.BaseFragment
import ru.kn_n.tasks.R
import ru.kn_n.tasks.databinding.FragmentTasksBinding
import ru.kn_n.tasks.domain.TaskEntity
import ru.kn_n.tasks.presentation.viewModel.TasksViewModel
import javax.inject.Inject

class TasksFragment : BaseFragment<FragmentTasksBinding>(FragmentTasksBinding::inflate) {
    @Inject
    lateinit var viewModel: TasksViewModel

    private val adapter by lazy { RecyclerViewAdapter(
        onTaskClick = ::onTaskClick
    ) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
        initRecycler()
        getData()
    }

    private fun getData() {
        viewModel.getTasks()
        viewModel.resultTasks.observe(viewLifecycleOwner){
            setData(it)
        }
    }

    private fun setData(data: Pair<List<TaskEntity>, String>) {
        adapter.setUserId(data.second)
        adapter.setItems(data.first)
    }

    private fun initRecycler() {
        binding.rvTasksList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTasksList.adapter = adapter
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory)[TasksViewModel::class.java]
    }

    private fun onTaskClick(id: String){
        val bundle = Bundle()
        bundle.putString("ID", id)
        findNavController().navigate(R.id.action_tasksFragment_to_taskDetailsFragment, bundle)
    }
}