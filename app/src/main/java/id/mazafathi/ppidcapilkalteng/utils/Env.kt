package id.mazafathi.ppidcapilkalteng.utils

import android.content.Context
import android.net.Uri
import id.mazafathi.ppidcapilkalteng.R

object Env {
    private lateinit var applicationContext: Context

    fun initialize(context: Context) {
        applicationContext = context.applicationContext
    }

    fun url(endpoint: String, prefix: String = "/ppid"): String {
        val paths = listOf(prefix, endpoint)
        val uri = Uri.Builder()
            .scheme(applicationContext.getString(R.string.scheme))
            .authority(applicationContext.getString(R.string.host))
        for (path in paths) {
            uri.appendEncodedPath(path)
        }
        return uri.build().toString().replace("(?<!https:)//+".toRegex(), "/")
    }
}