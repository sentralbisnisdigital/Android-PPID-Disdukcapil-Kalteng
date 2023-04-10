package disdukcapil.kalteng.ppid.models

import android.os.Parcelable
import disdukcapil.kalteng.ppid.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Menu(
    val icon: Int? = R.drawable.law,
    val title: String?,
    val subtitle: String?,
    val url: String?,
    val destination: Class<*>?
): Parcelable
