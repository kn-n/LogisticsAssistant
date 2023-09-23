package ru.kn_n.tasks.domain

import ru.kn_n.core.utils.EMPTY

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
    var status: StatusJob = StatusJob.NONE,
    val rules: String = String.EMPTY,
    var idPerformer: String = String.EMPTY,
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
        type = "done",
        title = "Работа выполнена",
        subtitle = "Задание было успешно выполнено"
    ),
    WAITING(
        type = "waiting",
        title = "Ваш ответ принят",
        subtitle = "Вам поступит подтверждение о выполнении задания"
    ),
    DECLINE(
        type = "decline",
        title = "Выполнение задания отклонено",
        subtitle = "Вы отклонили задание для выполнения"
    ),
    NOT_RELEVANT(
        type = "notRelevant",
        title = "Исполнители найдены",
        subtitle = "Задание не актуально для выполнения"
    )
}