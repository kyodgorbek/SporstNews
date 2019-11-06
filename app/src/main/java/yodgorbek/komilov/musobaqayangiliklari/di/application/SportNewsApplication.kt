package yodgorbek.komilov.musobaqayangiliklari.di.application

import android.app.Application

import org.koin.android.ext.koin.androidContext

import org.koin.core.context.startKoin
import yodgorbek.komilov.musobaqayangiliklari.di.application.module.appModules

class SportNewsApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        // Adding Koin modules to our application
        startKoin {
            androidContext(this@SportNewsApplication)
            modules(appModules)
        }
    }
}