package ru.kn_n.tasks.navigation

sealed interface TaskDetailsDirections{
    object Up : TaskDetailsDirections
    object ToIncident : TaskDetailsDirections
    object ToError : TaskDetailsDirections
    object ToAttachDocuments : TaskDetailsDirections
}