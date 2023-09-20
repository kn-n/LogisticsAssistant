package ru.kn_n.tasks.navigation

sealed interface TasksDirections{
    object ToTaskDetails : TasksDirections
}