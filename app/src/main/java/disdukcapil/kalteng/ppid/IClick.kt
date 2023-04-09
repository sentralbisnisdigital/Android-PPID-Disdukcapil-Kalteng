package disdukcapil.kalteng.ppid

import disdukcapil.kalteng.ppid.databinding.ItemMenuBinding

interface IClick {
    fun onClick(note : Menu, position : Int, view : ItemMenuBinding)
}