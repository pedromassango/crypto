package com.pedromassango.crypto

import android.app.Application
import com.pedromassango.crypto.di.DependenciesModules
import org.koin.android.ext.android.startKoin

class CryptoApp: Application(){

    override fun onCreate() {
        super.onCreate()

        // start koin
        startKoin(this, listOf(DependenciesModules.appModule))
    }
}