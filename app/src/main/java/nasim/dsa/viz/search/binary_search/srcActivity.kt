package nasim.dsa.viz.search.binary_search

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import nasim.dsa.viz.R
import nasim.dsa.viz.databinding.ActivitySrcBinding
import nasim.dsa.viz.search.binary_search.linear_search.LinearSearch

class srcActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySrcBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySrcBinding.inflate(layoutInflater)
        setContentView( binding.root)


        binding.BinarySearch.setOnClickListener {
            startActivity(Intent(this@srcActivity, BinarySearch::class.java))
        }

        binding.linearSearch.setOnClickListener {
            startActivity(Intent(this@srcActivity,LinearSearch::class.java))
        }
    }
}