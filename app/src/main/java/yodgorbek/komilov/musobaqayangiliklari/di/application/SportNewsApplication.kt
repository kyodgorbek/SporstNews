package yodgorbek.komilov.musobaqayangiliklari.di.application


import android.app.Application
import org.koin.core.context.startKoin
import yodgorbek.komilov.musobaqayangiliklari.di.application.module.*

class SportNewsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        // Adding Koin modules to our application
        startKoin {
            modules(listOf(netModule, appModules, bbcModules, espnModules, footballItaliaModules, databaseModule, repositoryModule))
        }

    }
}
