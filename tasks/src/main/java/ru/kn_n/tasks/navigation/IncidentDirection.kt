package ru.kn_n.tasks.navigation

sealed interface IncidentDirection{
    object Up : IncidentDirection
    object ToTaskDetails : IncidentDirection
}