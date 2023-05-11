package disdukcapil.kalteng.ppid.utils

import disdukcapil.kalteng.ppid.views.fragments.AllMenuFragment
import disdukcapil.kalteng.ppid.models.Menu
import disdukcapil.kalteng.ppid.R

object MenuObject {
    private const val URL = "https://disdukcapil.ferys2195.masuk.id"
    private fun url(path: String, prefix: String = "/ppid") = URL + prefix + path
    fun item(): ArrayList<Menu> {
        return arrayListOf(
            Menu(
                icon = R.drawable.legal_document,
                title = "Dasar Hukum",
                url = url("/dasar-hukum"),
                subMenu = null,
                subtitle = "lorem",
                destination = null
            ),
            Menu(
                icon = R.drawable.purpose,
                title = "Visi Misi",
                url = url("/visi-misi"),
                subtitle = "lorem",
                subMenu = null,
                destination = null
            ),
            Menu(
                icon = R.drawable.organization_chart,
                title = "Struktur Organisasi",
                url = url("/struktur-organisasi"),
                subtitle = "lorem",
                subMenu = null,
                destination = null
            ),
            Menu(
                icon = R.drawable.prioritize,
                title = "Tugas dan Fungsi",
                url = url("/tupoksi"),
                subMenu = null,
                subtitle = "lorem",
                destination = null
            ),
            Menu(
                icon = R.drawable.advertisement,
                title = "Maklumat Pelayanan",
                url = url("/maklumat-pelayanan"),
                subMenu = null,
                subtitle = "lorem",
                destination = null
            ),
            Menu(
                icon = R.drawable.sop,
                title = "Standar Operasional Prosedur",
                url = url("/sop"),
                subtitle = "lorem",
                subMenu = null,
                destination = null
            ),
            Menu(
                icon = R.drawable.planning,
                title = "Alur Layanan",
                url = null,
                subtitle = "lorem",
                destination = null,
                subMenu = subMenu(
                    permintaanInformasi = url("/permintaan-informasi", "/ppid/alur"),
                    keberatan = url("/keberatan", "/ppid/alur"),
                    penyelesaianSengketa = url("/penyelesaian-sengketa", "/ppid/alur"),
                    pengaduan = url("/pengaduan", "/ppid/alur")
                )
            ),
            Menu(
                icon = R.drawable.steps,
                title = "Tata Cara",
                url = null,
                subtitle = "lorem",
                destination = null,
                subMenu = subMenu(
                    permintaanInformasi = url("/permintaan-informasi", "/ppid/tata-cara"),
                    keberatan = url("/keberatan", "/ppid/tata-cara"),
                    penyelesaianSengketa = url("/penyelesaian-sengketa", "/ppid/tata-cara"),
                    pengaduan = url("/pengaduan", "/ppid/tata-cara")
                )
            ),
            Menu(
                icon = R.drawable.contact_form,
                title = "Formulir Layanan",
                url = null,
                subtitle = "lorem",
                destination = null,
                subMenu = subMenu(
                    permintaanInformasi = url("/permintaan-informasi", "/ppid/formulir-layanan"),
                    keberatan = url("/keberatan", "/ppid/formulir-layanan"),
                    penyelesaianSengketa = url("/penyelesaian-sengketa", "/ppid/formulir-layanan"),
                    pengaduan = url("/pengaduan", "/ppid/formulir-layanan")
                )
            ),
        )
    }

    fun subMenu(
        permintaanInformasi: String = url("/permohonan", "/formulir"),
        pengaduan: String = url("/pengaduan", "/formulir"),
        keberatan: String = url("/keberatan", "/formulir"),
        penyelesaianSengketa: String = url("/penyelesaian-sengketa", "/formulir")
    ): ArrayList<Menu> {
        return arrayListOf(
            Menu(
                icon = R.drawable.proposal,
                title = "Permintaan Informasi",
                url = permintaanInformasi,
                subtitle = "lorem",
                subMenu = null,
                destination = null

            ),
            Menu(
                icon = R.drawable.angry_customer,
                title = "Pengaduan",
                url = pengaduan,
                subtitle = "lorem",
                subMenu = null,
                destination = null
            ),
            Menu(
                icon = R.drawable.dissatisfied,
                title = "Keberatan Atas Informasi",
                url = keberatan,
                subtitle = "lorem",
                subMenu = null,
                destination = null
            ),
            Menu(
                icon = R.drawable.dispute,
                title = "Penyelesaian Sengketa ke Komisi Informasi",
                url = penyelesaianSengketa,
                subtitle = "lorem",
                subMenu = null,
                destination = null
            ),
        )
    }

    val addAppsButton = Menu(
        icon = R.drawable.app,
        title = "All Apps",
        url = null,
        subMenu = null,
        subtitle = "lorem",
        destination = AllMenuFragment::class.java
    )
}