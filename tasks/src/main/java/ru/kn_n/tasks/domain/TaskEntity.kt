package ru.kn_n.tasks.domain

import android.content.res.Resources
import android.graphics.Color
import ru.kn_n.core.utils.EMPTY
import ru.kn_n.core.utils.getStringResource
import ru.kn_n.tasks.R

data class TaskEntity(
    val id: String = String.EMPTY,
    val cargoType: String = String.EMPTY,
    val performersCity: String = String.EMPTY,
    val date: String = String.EMPTY,
    val time: String = String.EMPTY,
    val startPoint: String = String.EMPTY,
    val endPoint: String = String.EMPTY,
    val bodyType: String = String.EMPTY,
    val offerDetails: String = String.EMPTY,
    val paymentOptions: String = String.EMPTY,
    val contactPhone: String = String.EMPTY,
    val contactName: String = String.EMPTY,
    val status: StatusJob = StatusJob.NONE,
    val rules: String = String.EMPTY,
    val idPerformer: String = String.EMPTY,
    val attachedDocuments: List<String> = emptyList(),
    val incidents: List<String> = emptyList(),
    val errors: List<String> = emptyList()
)
enum class StatusJob(val type: String, val title: String, val subtitle: String) {
    NONE(
        "none",
        String.EMPTY,
        String.EMPTY,

    ),
    DONE(
        "done",
        getStringResource(R.string.status_done_title),
        getStringResource(R.string.status_done_subtitle)
    ),
    WAITING(
        "waiting",
        getStringResource(R.string.status_waiting_title),
        getStringResource(R.string.status_waiting_subtitle)
    ),
    DECLINE(
        "decline",
        getStringResource(R.string.status_decline_title),
        getStringResource(R.string.status_decline_subtitle)
    ),
    NOT_RELEVANT(
        "notRelevant",
        getStringResource(R.string.status_not_relevant_title),
        getStringResource(R.string.status_not_relevant_subtitle)
    )
}