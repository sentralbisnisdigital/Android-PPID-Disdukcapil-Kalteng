package disdukcapil.kalteng.ppid

import android.app.Application
import disdukcapil.kalteng.ppid.di.databaseModule
import disdukcapil.kalteng.ppid.di.repoModule
import disdukcapil.kalteng.ppid.di.viewModelModule
import disdukcapil.kalteng.ppid.utils.Env
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class PPIDApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(listOf(databaseModule, repoModule, viewModelModule))
        }
        Env.initialize(applicationContext)
    }
}

