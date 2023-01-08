package nasim.dsa.viz.search.binary_search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import nasim.dsa.viz.R
import nasim.dsa.viz.databinding.ActivityInsertionBinding

class MaizActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInsertionBinding
    private  var arr: ArrayList<Int> = ArrayList()
    private lateinit var adapter: InsertionAdapter
    private var element: Int = 25
    private var vis: ArrayList<Int> = ArrayList()
    private var visnew: ArrayList<Int> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maiz)
        binding = ActivityInsertionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = InsertionAdapter(arr,vis,visnew, this)

        arr.clear()

        for(i in 0..24){

            arr.add(0)
            vis.add(0)
            visnew.add(0)
        }
        var rand = (4..9).shuffled().last()
        for(i in 0..rand){
            var random1 = (0..24).shuffled().last()
            arr[random1] = 2
        }

        binding.backArrow.setOnClickListener { onBackPressed() }


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


            var key:Int =0
            var j:Int =0
            var n = arr.size
            for(i in 1 until n){
                vis[i] = 1
                delay(650)
                adapter =  InsertionAdapter(arr,vis,visnew,applicationContext)
                binding.itemList.adapter = adapter
                key = arr[i]
                j= i-1

                while (j >= 0 && arr[j] > key)
                {
                    visnew[j] = 1
                    arr[j + 1] = arr[j]

                    adapter = InsertionAdapter(arr,vis,visnew,applicationContext)
                    binding.itemList.adapter = adapter

                    delay(650)
                    visnew[j] = 0
                    j = j - 1


                }
                vis[i] = 0
                arr[j + 1] = key;
            }



        }.invokeOnCompletion {
            binding.search.isEnabled = true
        }


    }


}


