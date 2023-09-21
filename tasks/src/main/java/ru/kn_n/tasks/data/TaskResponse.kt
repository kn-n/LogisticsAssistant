package ru.kn_n.tasks.data

class TaskResponse(
    val id: String?,
    val cargoType: String?,
    val performersCity: String?,
    val date: String?,
    val time: String?,
    val startPoint: String?,
    val endPoint: String?,
    val bodyType: String?,
    val offerDetails: String?,
    val paymentOptions: String?,
    val contactPhone: String?,
    val contactName: String?,
    val status: String?,
    val rules: String?,
    val idPerformer: String?,
    val attachedDocuments: List<String>?,
    val incidents: List<String>?,
    val errors: List<String>?
)