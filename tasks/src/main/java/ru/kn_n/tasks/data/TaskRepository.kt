package ru.kn_n.tasks.data

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import io.reactivex.rxjava3.core.Emitter
import io.reactivex.rxjava3.core.Observable
import ru.kn_n.tasks.domain.TaskEntity
import javax.inject.Inject

class TaskRepository @Inject constructor(
    private val taskApi: TaskApi,
    private val taskResponseToEntityMapper: TaskResponseToEntityMapper
) {
    fun getTask(): Observable<List<TaskEntity>> =
        createObservableTasks().map(taskResponseToEntityMapper::mapTaskListResponse)

    fun getTasksDetails(id: String): Observable<TaskEntity> =
        createObservableTaskDetails(id).map(taskResponseToEntityMapper::mapTaskDetailsResponse)

    private fun createObservableTasks(): Observable<DataSnapshot> {
        return Observable.create {
            getSnapshotTasks(it)
        }
    }

    private fun getSnapshotTasks(emitter: Emitter<DataSnapshot>) {
        taskApi.getTasks()
            .addValueEventListener(
                object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        emitter.onNext(snapshot)
                        emitter.onComplete()
                    }

                    override fun onCancelled(error: DatabaseError) {}
                }
            )
    }

    private fun createObservableTaskDetails(id: String): Observable<DataSnapshot> {
        return Observable.create {
            getSnapshotTaskDetails(it, id)
        }
    }

    private fun getSnapshotTaskDetails(emitter: Emitter<DataSnapshot>, id: String) {
        taskApi.getTaskDetails(id)
            .addValueEventListener(
                object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        emitter.onNext(snapshot)
                        emitter.onComplete()
                    }

                    override fun onCancelled(error: DatabaseError) {}
                }
            )
    }
}