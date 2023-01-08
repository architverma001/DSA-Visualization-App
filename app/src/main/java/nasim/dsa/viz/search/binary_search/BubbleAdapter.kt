package nasim.dsa.viz.search.binary_search

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import nasim.dsa.viz.R
import nasim.dsa.viz.databinding.ItemNodeBinding

class BubbleAdapter(private val list: ArrayList<Int>,private val list2:ArrayList<Int>,private val list3: ArrayList<Int>, private val context: Context) :
    RecyclerView.Adapter<BubbleAdapter.LinearSearchViewHolder>() {

    private var row:Int = -1
    private var found:Int = -1


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LinearSearchViewHolder {
        return LinearSearchViewHolder(
            ItemNodeBinding.inflate(LayoutInflater.from(context),parent,false)
        )

    }

    override fun onBindViewHolder(holder: LinearSearchViewHolder, position: Int) {
        holder.binding.itemText.text = list[position].toString()

       if(list2[position]==1 ){
           holder.binding.itemText.setBackgroundResource(R.drawable.found)
       }

        if(list3[position]==1 ){
            holder.binding.itemText.setBackgroundResource(R.drawable.found)
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

