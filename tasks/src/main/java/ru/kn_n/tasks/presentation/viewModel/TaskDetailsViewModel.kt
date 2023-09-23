package ru.kn_n.tasks.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.kn_n.core.base.BaseViewModel
import ru.kn_n.core.utils.RxError
import ru.kn_n.tasks.domain.TaskEntity
import ru.kn_n.tasks.domain.TasksInteractor
import javax.inject.Inject

class TaskDetailsViewModel @Inject constructor(
    private val tasksInteractor: TasksInteractor
) : BaseViewModel() {

    private val _resultTaskDetails = MutableLiveData<TaskEntity>()
    val resultTaskDetails: LiveData<TaskEntity> = _resultTaskDetails

    fun getTaskDetails(id: String) {
        tasksInteractor.getTaskDetails(id)
            .doOnNext(::sendData)
            .subscribe({}, RxError.doNothing())
            .addFullLifeCycle()
    }

    private fun sendData(task : TaskEntity) {
        _resultTaskDetails.postValue(task)
    }
}