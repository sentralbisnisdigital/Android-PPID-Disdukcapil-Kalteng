package disdukcapil.kalteng.ppid.data.source.local.dao

import androidx.room.*
import disdukcapil.kalteng.ppid.data.models.Tracking
import kotlinx.coroutines.flow.Flow

@Dao
interface TrackingDao {
    @Query("SELECT * FROM trackings ORDER BY uid DESC LIMIT 5")
    fun getAll() : Flow<List<Tracking>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(vararg trackings: Tracking)

    @Delete
    suspend fun deleteItem(vararg tracking: Tracking)
}