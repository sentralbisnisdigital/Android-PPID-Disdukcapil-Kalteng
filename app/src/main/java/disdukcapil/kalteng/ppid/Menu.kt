package disdukcapil.kalteng.ppid

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Menu(
    val icon: Int?,
    val title: String?,
    val subtitle: String?,
    val url: String?,
    val destination: Class<*>?
): Parcelable
