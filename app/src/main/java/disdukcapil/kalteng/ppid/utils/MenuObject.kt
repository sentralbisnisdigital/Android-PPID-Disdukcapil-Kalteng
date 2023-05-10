package disdukcapil.kalteng.ppid.utils

import disdukcapil.kalteng.ppid.views.fragments.AllMenuFragment
import disdukcapil.kalteng.ppid.models.Menu
import disdukcapil.kalteng.ppid.R

object MenuObject {
    private const val URL = "https://disdukcapil.ferys2195.masuk.id/ppid"
    private fun url(path : String) = URL + path
    fun item(): ArrayList<Menu> {
        return arrayListOf(
            Menu(
                icon = R.drawable.law,
                title = "Dasar Hukum",
                url = url("/dasar-hukum"),
                subtitle = "lorem",
                destination = null
            ),
            Menu(

                title = "Visi Misi",
                url = url("/visi-misi"),
                subtitle = "lorem",
                destination = null
            ),
            Menu(

                title = "Struktur Organisasi",
                url = url("/struktur-organisasi"),
                subtitle = "lorem",
                destination = null
            ),
            Menu(

                title = "Tugas dan Fungsi",
                url = url("/tupoksi"),
                subtitle = "lorem",
                destination = null
            ),
            Menu(

                title = "Maklumat Pelayanan",
                url = url("/maklumat-pelayanan"),
                subtitle = "lorem",
                destination = null
            ),
            Menu(
                icon = R.drawable.proposal,
                title = "Standar Operasional Prosedur",
                url = url("/sop"),
                subtitle = "lorem",
                destination = null
            ),
            Menu(

                title = "Alur Layanan",
                url = "https://github.com",
                subtitle = "lorem",
                destination = null
            ),
            Menu(

                title = "Tata Cara",
                url = "https://astro.build",
                subtitle = "lorem",
                destination = null
            ),
            Menu(

                title = "Formulir Layanan",
                url = "https://nextjs.org",
                subtitle = "lorem",
                destination = null
            ),
        )
    }

    fun submissionItemMenu(): ArrayList<Menu> {
        return arrayListOf(
            Menu(
                icon = R.drawable.law,
                title = "Permintaan Informasi",
                url = "https://disdukcapil.ferys2195.masuk.id/formulir/permohonan",
                subtitle = "lorem",
                destination = null
            ),
            Menu(
                icon = R.drawable.proposal,
                title = "Pengaduan",
                url = "https://laravel.com",
                subtitle = "lorem",
                destination = null
            ),
            Menu(

                title = "Keberatan Atas Informasi",
                url = "https://disdukcapil.ferys2195.masuk.id/formulir/keberatan",
                subtitle = "lorem",
                destination = null
            ),
            Menu(

                title = "Penyelesaian Sengketa ke Komisi Informasi",
                url = "https://nextjs.org",
                subtitle = "lorem",
                destination = null
            ),
        )
    }

    val addAppsButton = Menu(
        icon = R.drawable.app,
        title = "All Apps",
        url = null,
        subtitle = "lorem",
        destination = AllMenuFragment::class.java
    )
}