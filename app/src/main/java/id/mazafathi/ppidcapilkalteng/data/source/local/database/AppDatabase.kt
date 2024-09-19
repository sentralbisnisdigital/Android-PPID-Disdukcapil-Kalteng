package id.mazafathi.ppidcapilkalteng.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import id.mazafathi.ppidcapilkalteng.data.source.local.dao.TrackingDao
import id.mazafathi.ppidcapilkalteng.data.models.Tracking

@Database(entities = [Tracking::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    abstract val trackingDao : TrackingDao
}