package id.mazafathi.ppidcapilkalteng

import android.app.Application
import id.mazafathi.ppidcapilkalteng.di.databaseModule
import id.mazafathi.ppidcapilkalteng.di.repoModule
import id.mazafathi.ppidcapilkalteng.di.viewModelModule
import id.mazafathi.ppidcapilkalteng.utils.Env
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(listOf(databaseModule, repoModule, viewModelModule))
        }
        Env.initialize(applicationContext)
    }
}

