package nasim.dsa.viz.search.binary_search.linear_search

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.coroutines.*
import nasim.dsa.viz.BaseActivity

import nasim.dsa.viz.search.binary_search.linear_search.adapter.LinearSearchAdapter
import nasim.dsa.viz.util.Constants
import nasim.dsa.viz.databinding.ActivityLinearSearchBinding

class LinearSearch : BaseActivity() {
    private lateinit var binding: ActivityLinearSearchBinding

    private var arr: MutableList<Int> = Constants.randomArr().toMutableList()
    private var adapter: LinearSearchAdapter = LinearSearchAdapter(arr, this)
    private var element: Int = 25

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLinearSearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backArrow.setOnClickListener { onBackPressed() }
        binding.randomGen.setOnClickListener {
            element += 5
            this.arr = Constants.randomArr(size = element, from = 0, to = 500).toMutableList()
            adapter = LinearSearchAdapter(arr, this)
            binding.itemList.adapter = this.adapter
            this.adapter.notifyDataSetChanged()
        }

        binding.itemList.layoutManager = GridLayoutManager(this, 5)
        binding.itemList.adapter = this.adapter

        binding.search.setOnClickListener {
            binding.result.text = ""
            binding.search.isEnabled = false
            binding.textInputLayout.error = null
            if (binding.searchItem.text!!.isEmpty()) {
                binding.textInputLayout.error = "Number required"
            } else {
                startSearch()
            }
        }

    }

    private fun startSearch() {
        val searchItem = binding.searchItem.text.toString().toInt()
        var flag = false
        CoroutineScope(Dispatchers.Main).launch {
            arr.forEachIndexed { index, i ->
                binding.itemList.scrollToPosition(index)
                adapter.updateItem(index)
                if (i == searchItem) {
                    flag = true
                    super.alert("Item $searchItem found at $index" + "th index")
                    binding.result.text = "Item $searchItem found at $index" + "th index"
                    return@launch
                }
                delay(450)
            }
            if (!flag) {
                super.alert("Item $searchItem not in list!")
                binding.result.text = "Item $searchItem not in list!"

            }

        }.invokeOnCompletion {
            binding.search.isEnabled = true
        }


    }

}