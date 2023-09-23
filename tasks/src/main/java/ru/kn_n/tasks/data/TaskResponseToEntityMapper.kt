package ru.kn_n.tasks.data

import com.google.firebase.database.DataSnapshot
import ru.kn_n.core.base.UserIdCache
import ru.kn_n.tasks.domain.StatusJob
import ru.kn_n.tasks.domain.TaskEntity
import javax.inject.Inject

class TaskResponseToEntityMapper @Inject constructor(
    private val cache: UserIdCache
) {
    fun mapTaskListResponse(data: DataSnapshot): List<TaskEntity> {
        val list = data.children.map { it.getValue(TaskResponse::class.java) }
        return list.map { mapTaskResponse(it) }
    }

    fun mapTaskDetailsResponse(data: DataSnapshot): TaskEntity =
        mapTaskResponse(data.getValue(TaskResponse::class.java))

    private fun mapTaskResponse(response: TaskResponse?): TaskEntity {
        return if (response == null) {
            TaskEntity()
        } else {
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
                    status =
                    if (cache.id == idPerformer) {
                        StatusJob.valueOf(status ?: StatusJob.NONE.name)
                    } else {
                        StatusJob.valueOf(publicStatus ?: StatusJob.NONE.name)
                    },
                    rules = rules.orEmpty(),
                    idPerformer = idPerformer.orEmpty(),
                    attachedDocuments = attachedDocuments.orEmpty(),
                    incidents = incidents.orEmpty(),
                    errors = errors.orEmpty()
                )
            }
        }
    }
}