package ru.kn_n.logisticsassistant.di

import android.content.Context
import toothpick.ktp.binding.module

fun appModule(context: Context) = module {
    //Global
    bind(Context::class.java).toInstance(context)


//    bind(APISearch::class.java).toProvider(RetrofitClientSearch::class.java)
//    bind(APIGifInfo::class.java).toProvider(RetrofitClientGifInfo::class.java)
}