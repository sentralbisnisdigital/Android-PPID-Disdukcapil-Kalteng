package id.mazafathi.ppidcapilkalteng.utils

import id.mazafathi.ppidcapilkalteng.ui.views.fragments.AllMenuFragment
import id.mazafathi.ppidcapilkalteng.data.models.Menu
import id.mazafathi.ppidcapilkalteng.R

object MenuObject {
    fun item(): ArrayList<Menu> {
        return arrayListOf(
            Menu(
                icon = R.drawable.legal_document,
                title = "Dasar Hukum",
                url = Env.url("/dasar-hukum"),
                subMenu = null,
                subtitle = "lorem",
                destination = null
            ),
            Menu(
                icon = R.drawable.purpose,
                title = "Visi Misi",
                url = Env.url("/visi-misi"),
                subtitle = "lorem",
                subMenu = null,
                destination = null
            ),
            Menu(
                icon = R.drawable.department,
                title = "Profil PPID",
                url = Env.url(""),
                subtitle = "lorem",
                subMenu = null,
                destination = null
            ),Menu(
                icon = R.drawable.organization_chart,
                title = "Struktur Organisasi",
                url = Env.url("/struktur-organisasi"),
                subtitle = "lorem",
                subMenu = null,
                destination = null
            ),
            Menu(
                icon = R.drawable.prioritize,
                title = "Tugas dan Fungsi",
                url = Env.url("/tupoksi"),
                subMenu = null,
                subtitle = "lorem",
                destination = null
            ),
            Menu(
                icon = R.drawable.advertisement,
                title = "Maklumat Pelayanan",
                url = Env.url("/maklumat-pelayanan"),
                subMenu = null,
                subtitle = "lorem",
                destination = null
            ),
            Menu(
                icon = R.drawable.indonesian_rupiah,
                title = "Tarif / Biaya",
                url = Env.url("/biaya"),
                subtitle = "lorem",
                destination = null,
            ),
            Menu(
                icon = R.drawable.sop,
                title = "Standar Operasional Prosedur",
                url = Env.url("/sop"),
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
                    permintaanInformasi = Env.url("/permintaan-informasi", "/ppid/alur"),
                    keberatan = Env.url("/keberatan", "/ppid/alur"),
                    penyelesaianSengketa = Env.url("/penyelesaian-sengketa", "/ppid/alur"),
                    pengaduan = Env.url("/pengaduan", "/ppid/alur")
                )
            ),
            Menu(
                icon = R.drawable.steps,
                title = "Tata Cara",
                url = null,
                subtitle = "lorem",
                destination = null,
                subMenu = subMenu(
                    permintaanInformasi = Env.url("/permintaan-informasi", "/ppid/tata-cara"),
                    keberatan = Env.url("/keberatan", "/ppid/tata-cara"),
                    penyelesaianSengketa = Env.url("/penyelesaian-sengketa", "/ppid/tata-cara"),
                    pengaduan = Env.url("/pengaduan", "/ppid/tata-cara")
                )
            ),
            Menu(
                icon = R.drawable.contact_form,
                title = "Formulir Layanan",
                url = Env.url("/formulir-layanan"),
                subtitle = "lorem",
                destination = null
            ),
        )
    }

    fun subMenu(
        permintaanInformasi: String = Env.url("/permohonan", "/formulir"),
        pengaduan: String = Env.url("/pengaduan", "/formulir"),
        keberatan: String = Env.url("/keberatan", "/formulir"),
        penyelesaianSengketa: String = Env.url("/penyelesaian-sengketa", "/formulir")
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
        title = "Lainnya",
        destination = AllMenuFragment::class.java
    )
}