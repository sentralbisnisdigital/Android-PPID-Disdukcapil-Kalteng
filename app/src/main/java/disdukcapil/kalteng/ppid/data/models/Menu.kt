package disdukcapil.kalteng.ppid.data.models

import android.os.Parcelable
import disdukcapil.kalteng.ppid.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Menu(
    val icon: Int? = null,
    val title: String? = "Detail",
    val subtitle: String? = null,
    val url: String? = null,
    val subMenu: ArrayList<Menu>? = null,
    val destination: Class<*>? = null
): Parcelable
