package disdukcapil.kalteng.ppid.utils

object Config {
    fun setTrackingTitle(trackingNumber: String): String {
        val split = trackingNumber.split("-")
        return if (split[0] == "PMN") "Permohonan" else "Keberatan"
    }

}