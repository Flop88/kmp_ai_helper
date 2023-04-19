package dev.mvlikhachev

import android.app.Application
import di.getSharedModules
import org.koin.core.context.startKoin

@Suppress("unused")
class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin { modules(getSharedModules()) }

    }
}