package nasim.dsa.viz.search.binary_search

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import nasim.dsa.viz.R
import nasim.dsa.viz.databinding.ActivitySrtBinding
import nasim.dsa.viz.databinding.ActivityStBinding

class stActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_st)
        binding = ActivityStBinding.inflate(layoutInflater)
        setContentView( binding.root)
        binding.queue.setOnClickListener {
            startActivity(Intent(this@stActivity,QueueActivity::class.java))
        }
        binding.stack.setOnClickListener {
            startActivity(Intent(this@stActivity,StackActivity::class.java))
        }
    }
}