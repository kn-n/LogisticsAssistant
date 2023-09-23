package ru.kn_n.tasks.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.kn_n.core.base.BaseViewModel
import ru.kn_n.core.base.UserIdCache
import ru.kn_n.core.utils.RxError
import ru.kn_n.tasks.domain.StatusJob
import ru.kn_n.tasks.domain.TaskEntity
import ru.kn_n.tasks.domain.TasksInteractor
import javax.inject.Inject

class TasksViewModel @Inject constructor(
    private val tasksInteractor: TasksInteractor,
    private val userIdCache: UserIdCache
) : BaseViewModel() {

    private val _resultTasks = MutableLiveData<Pair<List<TaskEntity>,String>>()
    val resultTasks: LiveData<Pair<List<TaskEntity>,String>> = _resultTasks

    fun getTasks() {
        tasksInteractor.getTasks()
            .doOnNext(::sendData)
            .subscribe({}, RxError.doNothing())
            .addFullLifeCycle()
    }

    private fun sendData(list: List<TaskEntity>) {
        val finalList = list.filter {
            it.status == StatusJob.NONE ||
                    it.status == StatusJob.NOT_RELEVANT ||
                    it.status == StatusJob.WAITING ||
                    it.status == StatusJob.DECLINE
        }
        _resultTasks.postValue(Pair(finalList, userIdCache.id))
    }
}