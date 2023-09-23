package ru.kn_n.tasks.domain

import ru.kn_n.tasks.data.TaskRepository
import javax.inject.Inject

class TasksInteractor @Inject constructor(private val tasksRepository: TaskRepository) {

    fun getTasks() = tasksRepository.getTask()

    fun getTaskDetails(id: String) = tasksRepository.getTasksDetails(id)
}