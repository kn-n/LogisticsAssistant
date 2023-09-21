package ru.kn_n.tasks.data

import ru.kn_n.tasks.domain.StatusJob
import ru.kn_n.tasks.domain.TaskEntity

class TaskResponseToEntityMapper {
    fun mapTaskListResponse(list: List<TaskResponse>) = list.map { mapTaskResponse(it) }

    private fun mapTaskResponse(response: TaskResponse) =
        with(response) {
            TaskEntity(
                id = id.orEmpty(),
                cargoType = cargoType.orEmpty(),
                performersCity = performersCity.orEmpty(),
                date = date.orEmpty(),
                time = time.orEmpty(),
                startPoint = startPoint.orEmpty(),
                endPoint = endPoint.orEmpty(),
                bodyType = bodyType.orEmpty(),
                offerDetails = offerDetails.orEmpty(),
                paymentOptions = paymentOptions.orEmpty(),
                contactPhone = contactPhone.orEmpty(),
                contactName = contactName.orEmpty(),
                status = status?.let { StatusJob.valueOf(it).name }.orEmpty(),
                rules = rules.orEmpty(),
                idPerformer = idPerformer.orEmpty(),
                attachedDocuments = attachedDocuments.orEmpty(),
                incidents = incidents.orEmpty(),
                errors = errors.orEmpty()
            )
        }
}