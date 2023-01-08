package nasim.dsa.viz.search.binary_search

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import nasim.dsa.viz.R
import nasim.dsa.viz.databinding.ActivityFirstpageBinding
import nasim.dsa.viz.databinding.ActivityStBinding

class Activity_firstpage : AppCompatActivity() {
    private lateinit var binding: ActivityFirstpageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firstpage)
        binding = ActivityFirstpageBinding.inflate(layoutInflater)
        setContentView( binding.root)
        binding.searching.setOnClickListener {

            startActivity(Intent(this@Activity_firstpage,srcActivity::class.java))
        }
        binding.sorting.setOnClickListener {

            startActivity(Intent(this@Activity_firstpage,srtActivity::class.java))
        }
        binding.stackQueue.setOnClickListener {
            startActivity(Intent(this@Activity_firstpage,stActivity::class.java))
        }
    }
}