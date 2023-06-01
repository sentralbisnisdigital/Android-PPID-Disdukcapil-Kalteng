package disdukcapil.kalteng.ppid.di

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import disdukcapil.kalteng.ppid.daos.TrackingDao
import disdukcapil.kalteng.ppid.utils.Databases
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    fun provideDatabase(application: Application): Databases {
        return Room.databaseBuilder(application, Databases::class.java, "ppid.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideTrackingDao(database: Databases): TrackingDao {
        return database.trackingDao
    }
    single {
        provideDatabase(androidApplication())
    }
    single {
        provideTrackingDao(get())
    }
}