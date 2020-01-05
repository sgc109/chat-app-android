package com.sungho.mychatapp

import android.app.Application
import com.facebook.stetho.Stetho
import com.sungho.mychatapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)

        startKoin {
            androidLogger()

            androidContext(this@MyApplication)

            androidFileProperties()

            modules(appModule)
        }
    }
}