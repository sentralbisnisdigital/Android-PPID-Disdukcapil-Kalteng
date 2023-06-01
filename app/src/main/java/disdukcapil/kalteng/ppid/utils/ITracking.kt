package disdukcapil.kalteng.ppid.utils

import disdukcapil.kalteng.ppid.databinding.ItemMenuBinding
import disdukcapil.kalteng.ppid.models.Menu

interface ITracking<T, I> {
    fun onClick(item : T, position : Int, view : I)
    fun onItemDeleted(item: T, position: Int)
}