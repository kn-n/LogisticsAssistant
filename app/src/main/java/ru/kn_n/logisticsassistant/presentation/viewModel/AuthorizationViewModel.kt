package ru.kn_n.logisticsassistant.presentation.viewModel

import android.app.Activity
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.FirebaseException
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken
import ru.kn_n.core.base.BaseViewModel
import ru.kn_n.core.base.UserIdCache
import ru.kn_n.core.utils.RxError
import ru.kn_n.logisticsassistant.domain.AuthInteractor
import javax.inject.Inject

class AuthorizationViewModel @Inject constructor(
    private val authInteractor: AuthInteractor,
    private val userIdCache: UserIdCache
) : BaseViewModel() {

    private var storedVerificationId: String? = ""
    private lateinit var resendingToken: ForceResendingToken

    private val _resultAuth = MutableLiveData<String>()
    val resultAuth: LiveData<String> = _resultAuth

    fun startPhoneNumberVerification(phoneNumber: String, activity: Activity) {
        authInteractor.startPhoneNumberVerification(
            phoneNumber,
            activity,
            createCallback()
        )
    }

    fun verifyPhoneNumberWithCode(code: String) {
        storedVerificationId?.let {
            authInteractor.verifyPhoneNumberWithCode(it, code)
                .doOnNext(::dispatchUser)
                .subscribe({}, RxError.doNothing())
                .addFullLifeCycle()
        }
    }

    private fun dispatchUser(result: AuthResult) {
        if (result.user != null){

            userIdCache.id = result.user!!.phoneNumber!!.removePrefix("+")
            _resultAuth.postValue(result.user!!.phoneNumber)
        }
        Log.d("AUTH", "${result.user?.phoneNumber}")
    }

    private fun createCallback() =
        object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                Log.d("AUTH", "onVerificationCompleted:$credential")
                authInteractor.signInWithPhoneAuthCredential(credential)
            }

            override fun onVerificationFailed(e: FirebaseException) {
                Log.d("AUTH", "onVerificationFailed", e)
            }

            override fun onCodeSent(
                verificationId: String,
                token: ForceResendingToken
            ) {
                Log.d("AUTH", "onCodeSent:$verificationId")
                storedVerificationId = verificationId
                resendingToken = token
            }
        }
}