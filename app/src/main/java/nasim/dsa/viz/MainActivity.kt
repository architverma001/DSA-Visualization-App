package nasim.dsa.viz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import nasim.dsa.viz.databinding.ActivityMainBinding
import nasim.dsa.viz.search.linear_search.LinearSearch

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.linearSearch.setOnClickListener {
            activityChanger(LinearSearch::class.java)
        }
    }

    private fun <T> activityChanger(destination: Class<T>) {
        startActivity(Intent(this,destination))
    }
}