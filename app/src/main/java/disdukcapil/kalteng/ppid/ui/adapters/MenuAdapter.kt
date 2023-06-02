package disdukcapil.kalteng.ppid.ui.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import disdukcapil.kalteng.ppid.ui.views.utils.IClick
import disdukcapil.kalteng.ppid.data.models.Menu
import disdukcapil.kalteng.ppid.databinding.ItemMenuBinding

class MenuAdapter(private val itemList: ArrayList<Menu>, private val listener: IClick) :
    RecyclerView.Adapter<MenuAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemMenuBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemMenuBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(itemList[position]) {
                this.icon?.let { binding.imageView.setImageResource(it) }
                binding.textTitle.text = this.title
                binding.root.setOnClickListener {
                    listener.onClick(this, position, binding)
                }
            }
        }
    }
    fun addAll(it: List<Menu>) = itemList.addAll(it)

    fun removeItemInLastPosition() = itemList.removeAt(itemList.size - 1)

}