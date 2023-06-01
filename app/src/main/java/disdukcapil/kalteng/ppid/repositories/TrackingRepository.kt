package disdukcapil.kalteng.ppid.repositories

import android.util.Log
import androidx.annotation.WorkerThread
import disdukcapil.kalteng.ppid.daos.TrackingDao
import disdukcapil.kalteng.ppid.models.Tracking
import kotlinx.coroutines.flow.Flow

class TrackingRepository(private val trackingDao: TrackingDao) {
    val allTracking: Flow<List<Tracking>> = trackingDao.getAll()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(tracking: Tracking) {
        trackingDao.insertAll(tracking)
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun deleteItem(tracking: Tracking){
        trackingDao.deleteItem(tracking)
    }

}