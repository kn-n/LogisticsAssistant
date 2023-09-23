package ru.kn_n.profile.domain

import io.reactivex.rxjava3.core.Observable
import ru.kn_n.profile.data.ProfileRepository
import javax.inject.Inject

class ProfileInteractor @Inject constructor(private val profileRepository: ProfileRepository){
    fun getUser(idUser: String) = profileRepository.getUser(idUser)
}