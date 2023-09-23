package ru.kn_n.profile.data

import ru.kn_n.core.utils.EMPTY

class ProfileResponse(
    val id: String? = String.EMPTY,
    val imgUrl: String? = String.EMPTY,
    val name: String? = String.EMPTY,
    val post: String? = String.EMPTY,
    val serviceNumber: String? = String.EMPTY,
    val phone: String? = String.EMPTY,
    val citizenship: String? = String.EMPTY,
    val carType: String? = String.EMPTY,
    val carNumber: String? = String.EMPTY,
    val sickLeaves: List<SickLeaveResponse>? = emptyList(),
    val currentTaskId: String? = String.EMPTY
)

class SickLeaveResponse(
    val id: String? = String.EMPTY,
    val sickLeaveStatus: String? = String.EMPTY,
    val startDate: String? = String.EMPTY,
    val endDate: String? = String.EMPTY
)