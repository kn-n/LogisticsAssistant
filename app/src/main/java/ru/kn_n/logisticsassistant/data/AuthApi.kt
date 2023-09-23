package ru.kn_n.logisticsassistant.data

import com.google.firebase.auth.AuthCredential
import ru.kn_n.core.base.FirebaseClient
import javax.inject.Inject

class AuthApi @Inject constructor(private val client: FirebaseClient) {
    fun signInWithCredentials(credential: AuthCredential) = client.AUTH.signInWithCredential(credential)
}