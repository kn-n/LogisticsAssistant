package ru.kn_n.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import toothpick.Toothpick
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ViewModelFactory @Inject constructor() :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass.simpleName) {
            "AuthorizationViewModel" ->
                Toothpick.openScope(Scopes.APP_SCOPE).getInstance(modelClass) as T
            "TasksViewModel" ->
                Toothpick.openScopes(Scopes.APP_SCOPE, Scopes.TASKS_SCOPE)
                    .getInstance(modelClass) as T
            "TaskDetailsViewModel" ->
                Toothpick.openScopes(Scopes.APP_SCOPE, Scopes.TASKS_SCOPE)
                    .getInstance(modelClass) as T
            "DocumentsViewModel" ->
                Toothpick.openScopes(Scopes.APP_SCOPE, Scopes.TASKS_SCOPE)
                    .getInstance(modelClass) as T
            "IncidentViewModel" ->
                Toothpick.openScopes(Scopes.APP_SCOPE, Scopes.TASKS_SCOPE  )
                    .getInstance(modelClass) as T
            "ChartViewModel" ->
                Toothpick.openScopes(Scopes.APP_SCOPE, Scopes.CHART_SCOPE)
                    .getInstance(modelClass) as T
            "ProfileViewModel" ->
                Toothpick.openScopes(Scopes.APP_SCOPE, Scopes.PROFILE_SCOPE)
                    .getInstance(modelClass) as T
            else -> throw IllegalArgumentException("Unknown class name")
        }
    }
}