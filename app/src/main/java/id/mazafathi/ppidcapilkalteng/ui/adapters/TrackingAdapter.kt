package id.mazafathi.ppidcapilkalteng.ui.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.mazafathi.ppidcapilkalteng.databinding.ItemTrackingHistoryBinding
import id.mazafathi.ppidcapilkalteng.data.models.Tracking
import id.mazafathi.ppidcapilkalteng.ui.views.utils.ITracking

class TrackingAdapter(
    private val itemList: ArrayList<Tracking>,
    private val listener: ITracking<Tracking, ItemTrackingHistoryBinding>
) : RecyclerView.Adapter<TrackingAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemTrackingHistoryBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemTrackingHistoryBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(itemList[position]) {
                binding.textCode.text = this.trackingCode
                binding.textDate.text = this.createdAt
                binding.root.setOnClickListener {
                    listener.onClick(this, position, binding)
                }
                binding.btnDelete.setOnClickListener {
                    val itemPosition = holder.bindingAdapterPosition
                    val tracked = itemList[itemPosition]

                    listener.onItemDeleted(tracked, itemPosition)

                    itemList.removeAt(itemPosition)
                    notifyItemRemoved(itemPosition)
                }
            }
        }
    }

    fun addAll(it: List<Tracking>) {
        itemList.clear()
        itemList.addAll(it)
    }


}