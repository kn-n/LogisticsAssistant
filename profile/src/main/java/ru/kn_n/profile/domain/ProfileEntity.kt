package ru.kn_n.profile.domain

import ru.kn_n.core.utils.EMPTY

data class ProfileEntity(
    val id: String = String.EMPTY,
    val imgUrl: String = String.EMPTY,
    val name: String = String.EMPTY,
    val post: String = String.EMPTY,
    val serviceNumber: String = String.EMPTY,
    val phone: String = String.EMPTY,
    val citizenship: String = String.EMPTY,
    val carType: String = String.EMPTY,
    val carNumber: String = String.EMPTY,
    val sickLeaves: List<SickLeave> = emptyList(),
    val currentTaskId: String = String.EMPTY
)

data class SickLeave(
    val id: String = String.EMPTY,
    val sickLeaveStatus: String = SickLeaveStatus.OPENED.name,
    val startDate: String = String.EMPTY,
    val endDate: String = String.EMPTY
)

enum class SickLeaveStatus(value: String) {
    OPENED("opened"),
    CLOSE("close")
}
