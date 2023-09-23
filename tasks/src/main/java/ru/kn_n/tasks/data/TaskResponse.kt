package ru.kn_n.tasks.data

import ru.kn_n.core.utils.EMPTY

class TaskResponse(
    val id: String? = String.EMPTY,
    val cargoType: String? = String.EMPTY,
    val performersCity: String? = String.EMPTY,
    val date: String? = String.EMPTY,
    val time: String? = String.EMPTY,
    val startPoint: String? = String.EMPTY,
    val endPoint: String? = String.EMPTY,
    val bodyType: String? = String.EMPTY,
    val offerDetails: String? = String.EMPTY,
    val paymentOptions: String? = String.EMPTY,
    val contactPhone: String? = String.EMPTY,
    val contactName: String? = String.EMPTY,
    val publicStatus: String? = String.EMPTY,
    val status: String? = String.EMPTY,
    val rules: String? = String.EMPTY,
    val idPerformer: String? = String.EMPTY,
    val attachedDocuments: List<String>? = emptyList(),
    val incidents: List<String>? = emptyList(),
    val errors: List<String>? = emptyList()
)