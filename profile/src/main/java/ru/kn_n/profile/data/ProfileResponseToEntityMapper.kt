package ru.kn_n.profile.data

import com.google.firebase.database.DataSnapshot
import ru.kn_n.profile.domain.ProfileEntity
import ru.kn_n.profile.domain.SickLeave
import ru.kn_n.profile.domain.SickLeaveStatus
import javax.inject.Inject

class ProfileResponseToEntityMapper @Inject constructor() {
    fun mapProfileResponse(data: DataSnapshot?): ProfileEntity {
        val response = data?.getValue(ProfileResponse::class.java)
        return if (response == null) {
            ProfileEntity()
        } else {
            with(response) {
                ProfileEntity(
                    id = id.orEmpty(),
                    imgUrl = imgUrl.orEmpty(),
                    name = name.orEmpty(),
                    post = post.orEmpty(),
                    serviceNumber = serviceNumber.orEmpty(),
                    phone = phone.orEmpty(),
                    citizenship = citizenship.orEmpty(),
                    carType = carType.orEmpty(),
                    carNumber = carNumber.orEmpty(),
                    sickLeaves = sickLeaves?.map(::mapSickLeaveResponseToEntity).orEmpty(),
                    currentTaskId = currentTaskId.orEmpty()
                )
            }
        }
    }

    private fun mapSickLeaveResponseToEntity(response: SickLeaveResponse) =
        with(response) {
            SickLeave(
                id = id.orEmpty(),
                sickLeaveStatus = sickLeaveStatus?.let { SickLeaveStatus.valueOf(it) }?.name
                    ?: SickLeaveStatus.CLOSE.name,
                startDate = startDate.orEmpty(),
                endDate = endDate.orEmpty()
            )
        }
}