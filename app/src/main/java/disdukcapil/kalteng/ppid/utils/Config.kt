package disdukcapil.kalteng.ppid.utils

object Config {
    fun setTrackingTitle(trackingNumber: String): String {
        val split = trackingNumber.split("-")
        return if (split[0] == "PMN") "Permohonan" else "Keberatan"
    }
    fun webHeaders(): HashMap<String, String> {
        val headers = HashMap<String, String>()
        headers["Token"] = "RLB9KKFJTi0vQU54G9mTY6L6ILpJGAxaacGITSx1QdoYMVqg5xhA4Skaaf53G"
        return headers
    }

}