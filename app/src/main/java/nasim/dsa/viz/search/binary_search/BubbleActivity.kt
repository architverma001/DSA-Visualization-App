package nasim.dsa.viz.search.binary_search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.get
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import nasim.dsa.viz.R
import nasim.dsa.viz.databinding.ActivityBubbleBinding

class BubbleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBubbleBinding
    private  var arr: ArrayList<Int> = ArrayList()
    private lateinit var adapter: BubbleAdapter
    private var element: Int = 25
    private var vis: ArrayList<Int> = ArrayList()
    private var visnew: ArrayList<Int> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bubble)


      binding = ActivityBubbleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter =  BubbleAdapter(arr,vis,visnew, this)

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


         var k =0

            for (i in 0 until arr.size) {
                for (j in 0 until arr.size - 1) {
                    if (arr[j] > arr[j + 1]) {
                       temp = arr[j]
                        vis[j] = 1
                        visnew[j+1] = 1
                        delay(550)
                        adapter =  BubbleAdapter(arr,vis,visnew,applicationContext)
                        binding.itemList.adapter = adapter
                        arr[j] = arr[j+1]
                        arr[j+1] = temp
                        delay(500)
                        vis[j] = 0
                        visnew[j+1] = 0
                        adapter =  BubbleAdapter(arr,vis,visnew,applicationContext)
                        binding.itemList.adapter = adapter
                    }


                }

            }

        }.invokeOnCompletion {
            binding.search.isEnabled = true
        }


    }







}


