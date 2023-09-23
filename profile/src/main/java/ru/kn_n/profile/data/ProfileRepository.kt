package ru.kn_n.profile.data

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import io.reactivex.rxjava3.core.Emitter
import io.reactivex.rxjava3.core.Observable
import ru.kn_n.profile.domain.ProfileEntity
import javax.inject.Inject

class ProfileRepository @Inject constructor(
    private val profileApi: ProfileApi,
    private val profileResponseToEntityMapper: ProfileResponseToEntityMapper
) {
    fun getUser(idUser: String): Observable<ProfileEntity> =
        createObservable(idUser).map(profileResponseToEntityMapper::mapProfileResponse)

    private fun createObservable(idUser: String): Observable<DataSnapshot> {
        return Observable.create {
            getSnapshot(idUser, it)
        }
    }

    private fun getSnapshot(idUser: String, emitter: Emitter<DataSnapshot>) {
        profileApi.getUser(idUser)
            .addValueEventListener(
                object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        emitter.onNext(snapshot)
                        emitter.onComplete()
                    }

                    override fun onCancelled(error: DatabaseError) {}
                }
            )
    }
}