package nasim.dsa.viz.search.binary_search.linear_search.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import nasim.dsa.viz.R
import nasim.dsa.viz.databinding.ItemNodeBinding

class LinearSearchAdapter(private val list: List<Int>, private val context: Context) :
    RecyclerView.Adapter<LinearSearchAdapter.LinearSearchViewHolder>() {

    private var row:Int = -1
    private var found:Int = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LinearSearchViewHolder {
        return LinearSearchViewHolder(
            ItemNodeBinding.inflate(LayoutInflater.from(context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: LinearSearchViewHolder, position: Int) {
        holder.binding.itemText.text = list[position].toString()
        if (row == position ){
            holder.binding.itemText.setBackgroundResource(R.drawable.node_bg_hovered)
        }
        if(row>position){
            holder.binding.itemText.setBackgroundResource(R.drawable.checked)
        }
        else{

            holder.binding.itemText.setBackgroundResource(R.drawable.node_bg)
        }

    }

    override fun getItemCount() = list.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateItem(position: Int){
        this.row = position
        notifyDataSetChanged()
    }


    inner class LinearSearchViewHolder(val binding: ItemNodeBinding) : RecyclerView.ViewHolder(binding.root) {}

}

