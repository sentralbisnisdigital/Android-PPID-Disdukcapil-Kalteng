package disdukcapil.kalteng.ppid.ui.views.utils

import disdukcapil.kalteng.ppid.databinding.ItemMenuBinding
import disdukcapil.kalteng.ppid.data.models.Menu

interface IClick {
    fun onClick(menu : Menu, position : Int, view : ItemMenuBinding)
}