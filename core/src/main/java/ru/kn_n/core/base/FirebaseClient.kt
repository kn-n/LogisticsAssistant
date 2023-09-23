package ru.kn_n.core.base

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import javax.inject.Inject

class FirebaseClient @Inject constructor() {
    fun getUser(id: String) =
        FirebaseDatabase
            .getInstance("https://logistic-assistent-default-rtdb.europe-west1.firebasedatabase.app/")
            .reference
            .child(NODE_USERS)
            .child(id)

    fun getTasks() =
        FirebaseDatabase
            .getInstance("https://logistic-assistent-default-rtdb.europe-west1.firebasedatabase.app/")
            .reference
            .child(NODE_TASKS)

    fun getTaskDetails(id: String) =
        FirebaseDatabase
            .getInstance("https://logistic-assistent-default-rtdb.europe-west1.firebasedatabase.app/")
            .reference
            .child(NODE_TASKS)
            .child(id)

    val AUTH: FirebaseAuth = FirebaseAuth.getInstance()

    fun logOut(){
        AUTH.signOut()
    }

    companion object {
        private const val NODE_USERS = "Users"
        private const val NODE_TASKS = "Tasks"
    }
}