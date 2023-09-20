package ru.kn_n.profile.navigation

sealed interface ProfileDirections{
    object ToAuthorization : ProfileDirections
}