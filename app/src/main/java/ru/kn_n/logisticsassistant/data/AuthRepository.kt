package ru.kn_n.logisticsassistant.data

import android.app.Activity
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import io.reactivex.rxjava3.core.Emitter
import io.reactivex.rxjava3.core.Observable
import ru.kn_n.core.base.FirebaseClient
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val client: FirebaseClient,
    private val api: AuthApi
) {
    fun startPhoneNumberVerification(
        phoneNumber: String,
        requireActivity: Activity,
        callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks
    ) {
        client.AUTH.setLanguageCode("ru")
        val options = PhoneAuthOptions.newBuilder(client.AUTH)
            .setPhoneNumber(phoneNumber)
            .setTimeout(120L, TimeUnit.SECONDS)
            .setActivity(requireActivity)
            .setCallbacks(callbacks)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    fun verifyPhoneNumberWithCode(storedVerificationId: String, code: String) : Observable<AuthResult> {
        val credential = PhoneAuthProvider.getCredential(storedVerificationId, code)
        return signInWithPhoneAuthCredential(credential)
    }

    fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) : Observable<AuthResult> {
        return createObservable(credential)
    }

    private fun createObservable(credential: PhoneAuthCredential) : Observable<AuthResult> {
        return Observable.create{
            getTaskAuthResult(credential, it)
        }
    }

    private fun getTaskAuthResult(credential: PhoneAuthCredential, emitter: Emitter<AuthResult>) : Task<AuthResult> {
        return api.signInWithCredentials(credential)
            .addOnSuccessListener {
                emitter.onNext(it)
                emitter.onComplete()
            }
    }
}