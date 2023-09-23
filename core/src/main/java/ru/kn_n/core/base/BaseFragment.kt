package ru.kn_n.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import toothpick.Toothpick
import javax.inject.Inject

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<VB : ViewBinding>(private val inflate: Inflate<VB>) : Fragment() {
    private var _binding: VB? = null
    val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)

        setupViewModelFactory()

        return binding.root
    }

    private fun setupViewModelFactory() {
        viewModelFactory = Toothpick.openScope(Scopes.APP_SCOPE).getInstance(ViewModelFactory::class.java)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private val fullLifeCycleCompositeDisposable = CompositeDisposable()

    fun Disposable.addFullLifeCycle(): Disposable {
        fullLifeCycleCompositeDisposable.add(this)
        return this
    }
}