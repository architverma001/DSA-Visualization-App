package nasim.dsa.viz.search.binary_search

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import nasim.dsa.viz.R
import nasim.dsa.viz.databinding.ItemNodeBinding

class BinarySearchAdapter(private val list: ArrayList<Int>,private val vis: ArrayList<Int>, private val context: Context) :
    RecyclerView.Adapter<BinarySearchAdapter.LinearSearchViewHolder>() {

    private var row:Int = -1
    private var found:Int = -1


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LinearSearchViewHolder {
        return LinearSearchViewHolder(
            ItemNodeBinding.inflate(LayoutInflater.from(context),parent,false)
        )

    }
   var count = 0;
    override fun onBindViewHolder(holder: LinearSearchViewHolder, position: Int) {
        holder.binding.itemText.text = list[position].toString()
        if (row == position ){
            holder.binding.itemText.setBackgroundResource(R.drawable.node_bg_hovered)
            vis[position] = 1
            count++
        }



            if(vis[position]==1){
                holder.binding.itemText.setBackgroundResource(R.drawable.checked)
            }


    }

    override fun getItemCount() = list.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateItem(position: Int){
        this.row = position
        notifyDataSetChanged()
    }


    inner class LinearSearchViewHolder(val binding: ItemNodeBinding) : RecyclerView.ViewHolder(binding.root){}

}

