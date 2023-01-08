package nasim.dsa.viz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import nasim.dsa.viz.databinding.ActivityMainBinding
import nasim.dsa.viz.search.binary_search.*
import nasim.dsa.viz.search.binary_search.linear_search.LinearSearch

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.linearSearch.setOnClickListener {
            activityChanger(LinearSearch::class.java)
        }
        binding.binarySeach.setOnClickListener {
            activityChanger(BinarySearch::class.java)
        }
        binding.bbbleSort.setOnClickListener {
            activityChanger(BubbleActivity::class.java)
        }
        binding.bbbleSort2.setOnClickListener {
            activityChanger(InsertionActivity::class.java)
        }
        binding.selectinSORT.setOnClickListener {
            activityChanger(selectionActivity::class.java)
        }
        binding.selectinSORT2.setOnClickListener {
            activityChanger(StackActivity::class.java)
        }
        binding.selectinSORT3.setOnClickListener {
            activityChanger(QueueActivity::class.java)
        }
    }

    private fun <T> activityChanger(destination: Class<T>) {
        startActivity(Intent(this,destination))
    }
}