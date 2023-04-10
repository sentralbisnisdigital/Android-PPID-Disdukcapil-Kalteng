package disdukcapil.kalteng.ppid.utils

import disdukcapil.kalteng.ppid.views.fragments.AllMenuFragment
import disdukcapil.kalteng.ppid.models.Menu
import disdukcapil.kalteng.ppid.R

object MenuObject {
    fun item(): ArrayList<Menu> {
        return arrayListOf(
            Menu(
                icon = R.drawable.law,
                title = "Dasar Hukum",
                url = "https://ferys2195.github.io",
                subtitle = "lorem",
                destination = null
            ),
            Menu(
                icon = R.drawable.proposal,
                title = "Daftar Informasi Publik",
                url = "https://laravel.com",
                subtitle = "lorem",
                destination = null
            ),
            Menu(

                title = "Visi Misi",
                url = "https://astro.build",
                subtitle = "lorem",
                destination = null
            ),
            Menu(

                title = "Struktur Organisasi",
                url = "https://nextjs.org",
                subtitle = "lorem",
                destination = null
            ),
            Menu(

                title = "Tugas dan Fungsi",
                url = "https://github.com",
                subtitle = "lorem",
                destination = null
            ),
            Menu(

                title = "Maklumat Pelayanan",
                url = "https://astro.build",
                subtitle = "lorem",
                destination = null
            ),
            Menu(

                title = "Standar Operasional Prosedur",
                url = "https://nextjs.org",
                subtitle = "lorem",
                destination = null
            ),
            Menu(

                title = "Laporan",
                url = "https://github.com",
                subtitle = "lorem",
                destination = null
            ),
            Menu(

                title = "Biaya",
                url = "https://astro.build",
                subtitle = "lorem",
                destination = null
            ),
            Menu(

                title = "Layanan Informasi",
                url = "https://nextjs.org",
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

                title = "Formulir Layanan",
                url = "https://astro.build",
                subtitle = "lorem",
                destination = null
            )

        )
    }

    fun submissionItemMenu(): ArrayList<Menu> {
        return arrayListOf(
            Menu(
                icon = R.drawable.law,
                title = "Permintaan Informasi",
                url = "https://ferys2195.github.io",
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
                url = "https://astro.build",
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