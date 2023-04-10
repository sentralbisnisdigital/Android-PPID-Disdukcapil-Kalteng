package disdukcapil.kalteng.ppid.utils

import disdukcapil.kalteng.ppid.databinding.ItemMenuBinding
import disdukcapil.kalteng.ppid.models.Menu

interface IClick {
    fun onClick(menu : Menu, position : Int, view : ItemMenuBinding)
}