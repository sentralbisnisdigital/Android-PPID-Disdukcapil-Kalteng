package disdukcapil.kalteng.ppid.utils

import androidx.room.Database
import androidx.room.RoomDatabase
import disdukcapil.kalteng.ppid.daos.TrackingDao
import disdukcapil.kalteng.ppid.models.Tracking

@Database(entities = [Tracking::class], version = 1, exportSchema = false)
abstract class Databases : RoomDatabase(){
    abstract val trackingDao : TrackingDao
}