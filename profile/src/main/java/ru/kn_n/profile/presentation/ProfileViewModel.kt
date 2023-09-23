package ru.kn_n.profile.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.kn_n.core.base.BaseViewModel
import ru.kn_n.core.base.FirebaseClient
import ru.kn_n.core.base.UserIdCache
import ru.kn_n.core.utils.EMPTY
import ru.kn_n.core.utils.RxError
import ru.kn_n.profile.domain.ProfileEntity
import ru.kn_n.profile.domain.ProfileInteractor
import java.security.AuthProvider
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    private val profileInteractor: ProfileInteractor,
    private val userIdCache: UserIdCache,
    private val client: FirebaseClient
): BaseViewModel() {

    private val _resultProfile = MutableLiveData<ProfileEntity>()
    val resultProfile: LiveData<ProfileEntity> = _resultProfile

    fun getProfile() {
        val id = userIdCache.id
        profileInteractor.getUser(id)
            .doOnNext(::sendData)
            .subscribe({}, { RxError.doNothing() })
            .addFullLifeCycle()
    }

    private fun sendData(profile: ProfileEntity) {
        _resultProfile.postValue(profile)
    }

    fun logOut(){
        userIdCache.id = String.EMPTY
        client.logOut()
    }

}