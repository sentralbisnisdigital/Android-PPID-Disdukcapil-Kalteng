package disdukcapil.kalteng.ppid.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "trackings", indices = [(Index(value = ["tracking_code"], unique = true))])
data class Tracking(
    @PrimaryKey(autoGenerate = true) val uid: Int?,
    @ColumnInfo("tracking_code") val trackingCode: String?,
    @ColumnInfo("tracking_type") val trackingType: String? = null,
    @ColumnInfo("created_at") val createdAt: String? = null
) : Parcelable
