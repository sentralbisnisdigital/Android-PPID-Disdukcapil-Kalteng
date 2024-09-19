package id.mazafathi.ppidcapilkalteng.ui.views.utils

interface ITracking<T, I> {
    fun onClick(item : T, position : Int, view : I)
    fun onItemDeleted(item: T, position: Int)
}