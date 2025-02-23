package com.murosar.composempfirstapproach

import android.app.Application
import com.murosar.composempfirstapproach.di.initKoin
import org.koin.android.ext.koin.androidContext

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@MyApplication)
        }
    }
}