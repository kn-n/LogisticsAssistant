package ru.kn_n.core.base

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class BaseViewModel: ViewModel() {
    private val fullLifeCycleCompositeDisposable = CompositeDisposable()

    fun Disposable.addFullLifeCycle(): Disposable {
        fullLifeCycleCompositeDisposable.add(this)
        return this
    }
}