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
import nasim.dsa.viz.databinding.ActivityInsertionBinding
import nasim.dsa.viz.databinding.ActivitySelectionBinding

class selectionActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySelectionBinding
    private  var arr: ArrayList<Int> = ArrayList()
    private lateinit var adapter: SelectionAdapter
    private var element: Int = 25
    private var vis: ArrayList<Int> = ArrayList()
    private var visnew: ArrayList<Int> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection)


        binding = ActivitySelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter =  SelectionAdapter(arr,vis,visnew, this)

        arr.clear()

        for(i in 0..24){
            var random1 = (0..500).shuffled().last()
            arr.add(random1)
            vis.add(0)
            visnew.add(0)
        }


        binding.backArrow.setOnClickListener { onBackPressed() }
        binding.randomGen.setOnClickListener {
            arr.clear()
            element += 5
            for(i in 0..24){
                var random1 = (0..500).shuffled().last()
                arr.add(random1)
                vis.add(0)
                visnew.add(0)
            }

            binding.itemList.adapter = this.adapter
            this.adapter.notifyDataSetChanged()
        }

        binding.itemList.layoutManager = GridLayoutManager(this, 5)
        binding.itemList.adapter = this.adapter

        binding.search.setOnClickListener {
            binding.search.isEnabled = false
            sortit()
        }

    }


    private fun sortit() {

        var flag = false
        var low:Int = 0
        var high:Int = arr.size
        var temp:Int = 0
        CoroutineScope(Dispatchers.Main).launch {


            var minIndex:Int =0
            var j:Int =0
            var n = arr.size-1
            for(i in 0 until n){
                vis[i] = 1
                delay(950)
                adapter =   SelectionAdapter(arr,vis,visnew,applicationContext)
                binding.itemList.adapter = adapter
                minIndex = i
               for(j in (i+1) until arr.size){
                   visnew[j] = 2
                   adapter =   SelectionAdapter(arr,vis,visnew,applicationContext)
                   binding.itemList.adapter = adapter
                   delay(250)
                   if(arr[j]<arr[minIndex]){
                       visnew[j] = 1
                       minIndex = j
                       adapter =   SelectionAdapter(arr,vis,visnew,applicationContext)
                       binding.itemList.adapter = adapter
                       delay(600)
                       visnew[j] = 0
                   }
                   visnew[j] = 0
               }

                if(minIndex!=i){
                    var temp = arr[i]
                    arr[i] = arr[minIndex]
                    arr[minIndex] = temp
                }

                adapter =  SelectionAdapter(arr,vis,visnew,applicationContext)
                    binding.itemList.adapter = adapter
                 delay(650)
                vis[i] = 0

            }



        }.invokeOnCompletion {
            binding.search.isEnabled = true
        }


    }


}


