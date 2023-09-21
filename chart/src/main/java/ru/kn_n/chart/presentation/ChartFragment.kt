package ru.kn_n.chart.presentation

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import ru.kn_n.chart.databinding.FragmentChartBinding
import ru.kn_n.core.base.BaseFragment
import javax.inject.Inject

class ChartFragment : BaseFragment<FragmentChartBinding>(FragmentChartBinding::inflate) {

    @Inject
    lateinit var viewModel: ChartViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModule()
    }

    private fun setupViewModule() {
        viewModel = ViewModelProvider(this, viewModelFactory)[ChartViewModel::class.java]
    }
}