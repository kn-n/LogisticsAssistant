package ru.kn_n.logisticsassistant.domain

import android.app.Activity
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import ru.kn_n.logisticsassistant.data.AuthRepository
import javax.inject.Inject

class AuthInteractor @Inject constructor(private val repository: AuthRepository) {
    fun startPhoneNumberVerification(
        phoneNumber: String,
        requireActivity: Activity,
        callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks
    ) = repository.startPhoneNumberVerification(phoneNumber, requireActivity, callbacks)

    fun verifyPhoneNumberWithCode(storedVerificationId: String, code: String) =
        repository.verifyPhoneNumberWithCode(storedVerificationId, code)

    fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) =
        repository.signInWithPhoneAuthCredential(credential)
}