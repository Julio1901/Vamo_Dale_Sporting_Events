package com.julio.vamo_dale_sporting_events.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppApplication : Application() {

    override fun onCreate(){
        super.onCreate()

        startKoin {
            androidContext(this@AppApplication)
            modules(viewModelModule)

        }
    }

}