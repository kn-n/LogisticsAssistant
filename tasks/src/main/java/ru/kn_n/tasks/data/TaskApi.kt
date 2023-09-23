package ru.kn_n.tasks.data

import ru.kn_n.core.base.FirebaseClient
import javax.inject.Inject

class TaskApi @Inject constructor(private val firebaseClient: FirebaseClient){
    fun getTasks() = firebaseClient.getTasks()

    fun getTaskDetails(id: String) = firebaseClient.getTaskDetails(id)
}