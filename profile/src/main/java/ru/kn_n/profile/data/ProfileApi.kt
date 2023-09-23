package ru.kn_n.profile.data

import ru.kn_n.core.base.FirebaseClient
import javax.inject.Inject

class ProfileApi @Inject constructor(private val firebaseClient: FirebaseClient) {
    fun getUser(idUser: String) = firebaseClient.getUser(idUser)
}