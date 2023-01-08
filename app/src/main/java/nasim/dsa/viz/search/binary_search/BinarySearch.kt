package nasim.dsa.viz.search.binary_search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.view.get
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

import nasim.dsa.viz.R
import nasim.dsa.viz.databinding.ActivityBinarySearchBinding

class BinarySearch : AppCompatActivity() {
    private lateinit var binding: ActivityBinarySearchBinding

    private  var arr: ArrayList<Int> = ArrayList()
    private var vis:ArrayList<Int> = ArrayList()
    private lateinit var adapter: BinarySearchAdapter
    private var element: Int = 25

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBinarySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)



        adapter = BinarySearchAdapter(arr, vis,this)

        arr.clear()

        for(i in 0..24){
            var random1 = (0..500).shuffled().last()
            arr.add(random1)
            vis.add(0)

        }
        arr.sort()

        binding.backArrow.setOnClickListener { onBackPressed() }
        binding.randomGen.setOnClickListener {
            arr.clear()
            element += 5
      for(i in 0..24){
          var random1 = (0..500).shuffled().last()
          arr.add(random1)

      }
            arr.sort()



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
        var low:Int = 0
        var high:Int = arr.size-1
        var mid:Int = 0
        CoroutineScope(Dispatchers.Main).launch {



            while(high>=low) {
                 mid = (low + high) /2
                Log.d("mid",mid.toString())

                binding.itemList.scrollToPosition(mid)
                adapter.updateItem(mid)
                if (arr[mid] == searchItem) {
                    flag = true
                    Toast.makeText(this@BinarySearch,("Item $searchItem found at $mid" + "th index"),Toast.LENGTH_SHORT).show()
                    binding.result.text = "Item $searchItem found at $mid" + "th index"
                    binding.itemList[mid].setBackgroundResource(R.color.teal_200)
                    return@launch
                }

//                if (arr[high] == searchItem) {
//                    flag = true
//                    Toast.makeText(this@BinarySearch,("Item $searchItem found at $high" + "th index"),Toast.LENGTH_SHORT).show()
//                    binding.result.text = "Item $searchItem found at $high" + "th index"
//                    return@launch
//                }
                else if(arr[mid]<searchItem){

                    low = mid+1
                }
                else{

                    high = mid
                }
                Log.d("low",low.toString())
                Log.d("high",high.toString())
                delay(750)
            }


            if (!flag) {
                binding.result.text = "Item not found "
                binding.result.text = "Item $searchItem not in list!"

            }





        }.invokeOnCompletion {
            binding.search.isEnabled = true
        }


    }







}