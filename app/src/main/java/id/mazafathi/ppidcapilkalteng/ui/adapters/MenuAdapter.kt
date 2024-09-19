package id.mazafathi.ppidcapilkalteng.ui.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.mazafathi.ppidcapilkalteng.ui.views.utils.IClick
import id.mazafathi.ppidcapilkalteng.data.models.Menu
import id.mazafathi.ppidcapilkalteng.databinding.ItemMenuBinding

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

}