package disdukcapil.kalteng.ppid.di

import android.app.Application
import androidx.room.Room
import disdukcapil.kalteng.ppid.data.source.local.dao.TrackingDao
import disdukcapil.kalteng.ppid.data.source.local.database.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    fun provideDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "ppid.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideTrackingDao(database: AppDatabase): TrackingDao {
        return database.trackingDao
    }
    single {
        provideDatabase(androidApplication())
    }
    single {
        provideTrackingDao(get())
    }
}