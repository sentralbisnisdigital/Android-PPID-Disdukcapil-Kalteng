package id.mazafathi.ppidcapilkalteng.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Suppress("DEPRECATED_ANNOTATION")
@Parcelize
data class Menu(
    val icon: Int? = null,
    val title: String? = "Detail",
    val subtitle: String? = null,
    val url: String? = null,
    val subMenu: ArrayList<Menu>? = null,
    val destination: Class<*>? = null
): Parcelable
