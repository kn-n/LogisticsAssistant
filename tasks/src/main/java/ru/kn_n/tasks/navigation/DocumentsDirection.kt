package ru.kn_n.tasks.navigation

sealed interface DocumentsDirection{
    object Up : DocumentsDirection
    object ToTaskDetails : DocumentsDirection
}