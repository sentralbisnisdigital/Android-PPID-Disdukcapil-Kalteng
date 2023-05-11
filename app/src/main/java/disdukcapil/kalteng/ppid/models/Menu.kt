package disdukcapil.kalteng.ppid.models

import android.os.Parcelable
import disdukcapil.kalteng.ppid.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Menu(
    val icon: Int?,
    val title: String?,
    val subtitle: String?,
    val url: String?,
    val subMenu: ArrayList<Menu>?,
    val destination: Class<*>?
): Parcelable
