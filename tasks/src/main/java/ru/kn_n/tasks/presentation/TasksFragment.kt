package ru.kn_n.tasks.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ru.kn_n.core.base.BaseFragment
import ru.kn_n.tasks.databinding.FragmentTasksBinding

class TasksFragment: BaseFragment<FragmentTasksBinding>(FragmentTasksBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}