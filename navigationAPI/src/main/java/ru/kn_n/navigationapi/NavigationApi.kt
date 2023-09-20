package ru.kn_n.navigationapi

interface NavigationApi<DIRECTION> {
    fun navigate(direction:DIRECTION)
}