package disdukcapil.kalteng.ppid.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import disdukcapil.kalteng.ppid.data.source.local.dao.TrackingDao
import disdukcapil.kalteng.ppid.data.models.Tracking

@Database(entities = [Tracking::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    abstract val trackingDao : TrackingDao
}