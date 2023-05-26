package disdukcapil.kalteng.ppid.utils

import android.net.Uri
import disdukcapil.kalteng.ppid.R

object Env {
    private val uri = Uri.Builder()
    private val BASE_URL = uri.scheme(R.string.scheme.toString()).path(R.string.host.toString()).toString()
    fun url(endpoint: String, prefix: String = "/ppid") = BASE_URL + prefix + endpoint
}