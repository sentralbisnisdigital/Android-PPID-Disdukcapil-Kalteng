package disdukcapil.kalteng.ppid.ui.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import disdukcapil.kalteng.ppid.databinding.ItemHeaderBinding

class HeaderAdapter(private val itemList : ArrayList<String>) : RecyclerView.Adapter<HeaderAdapter.ViewHolder>() {
    class ViewHolder(val binding : ItemHeaderBinding) :RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemHeaderBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = 1

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.textTitle.text = itemList[position]
    }
    fun addAll(it : List<String>) = itemList.addAll(it)

}