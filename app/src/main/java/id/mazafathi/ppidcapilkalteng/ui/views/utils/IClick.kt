package id.mazafathi.ppidcapilkalteng.ui.views.utils

import id.mazafathi.ppidcapilkalteng.databinding.ItemMenuBinding
import id.mazafathi.ppidcapilkalteng.data.models.Menu

interface IClick {
    fun onClick(menu : Menu, position : Int, view : ItemMenuBinding)
}