package nasim.dsa.viz.search.binary_search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import nasim.dsa.viz.R

import nasim.dsa.viz.databinding.ActivityStackBinding

class StackActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStackBinding
    private  var arr: ArrayList<Int> = ArrayList(25)
    private lateinit var adapter:StackAdapter
    private var element: Int = 25
    private var vis: ArrayList<Int> = ArrayList()
    private var visnew: ArrayList<Int> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stack)
        binding =  ActivityStackBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter =  StackAdapter(arr,vis,visnew, this)

        arr.clear()


      for(i in 0..24){
          vis.add(0)
          visnew.add(0)
      }

        binding.backArrow.setOnClickListener { onBackPressed() }


        binding.itemList.layoutManager = GridLayoutManager(this, 5)
        binding.itemList.adapter = this.adapter

        binding.add.setOnClickListener {
            if(binding.addNumber.text.isNotEmpty()){
                if(arr.size==25){
                    Toast.makeText(this@StackActivity,"Stack is full",Toast.LENGTH_SHORT).show()
                }
                else{
            enqueit()}
            }
            else{
                Toast.makeText(this@StackActivity,"Enter text",Toast.LENGTH_SHORT).show()
            }
        }
        binding.remove.setOnClickListener {
            if(arr.size==0){
                Toast.makeText(this@StackActivity,"Stack Empty",Toast.LENGTH_SHORT).show()
            }
            else{
                dequeuit()
            }
        }

    }

    private fun dequeuit() {
     var  i = arr.size-1
        Log.d("Index",i.toString())
        Log.d("Arrybf",arr.toString())
     arr.removeLast()
        Log.d("Arryaft",arr.toString())
        if(i>1){
            visnew[i-1] = 1
        }
        adapter = StackAdapter(arr,vis,visnew, applicationContext)
        binding.itemList.adapter = adapter
    }


    private fun enqueit() {

        var flag = false
        var low:Int = 0
        var high:Int = arr.size
        var temp:Int = 0
        CoroutineScope(Dispatchers.Main).launch {


          var k = binding.addNumber.text.toString().toInt()
            arr.add(k)
            vis[0]=1
            var z = arr.size - 1
            if(z>0){
               visnew[z-1] = 0
            }
            visnew[z] = 1
            adapter = StackAdapter(arr,vis,visnew, applicationContext)

            binding.itemList.adapter = adapter
            binding.addNumber.text = null



        }


    }


}


