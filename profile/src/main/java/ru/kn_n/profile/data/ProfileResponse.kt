package ru.kn_n.profile.data

class ProfileResponse(
    val id: String?,
    val imgUrl: String?,
    val name: String?,
    val post: String?,
    val serviceNumber: String?,
    val phone: String?,
    val citizenship: String?,
    val carType: String?,
    val carNumber: String?,
    val sickLeaves: List<SickLeaveResponse>?,
    val currentTaskId: String?
)

class SickLeaveResponse(
    val id: String?,
    val sickLeaveStatus: String?,
    val startDate: String?,
    val endDate: String?
)