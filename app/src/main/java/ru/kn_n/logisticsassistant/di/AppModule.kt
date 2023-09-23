package ru.kn_n.logisticsassistant.di

import android.content.Context
import ru.kn_n.core.base.UserIdCache
import toothpick.ktp.binding.module

fun appModule(context: Context) = module {
    //Global
    bind(Context::class.java).toInstance(context)
    bind(UserIdCache::class.java).singleton()

}