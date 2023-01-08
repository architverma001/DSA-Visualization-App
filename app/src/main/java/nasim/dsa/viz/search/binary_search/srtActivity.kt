package nasim.dsa.viz.search.binary_search

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import nasim.dsa.viz.R
import nasim.dsa.viz.databinding.ActivitySrcBinding
import nasim.dsa.viz.databinding.ActivitySrtBinding

class srtActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySrtBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_srt)
        binding = ActivitySrtBinding.inflate(layoutInflater)
        setContentView( binding.root)
        binding.bblesort.setOnClickListener {
            startActivity(Intent(this@srtActivity,BubbleActivity::class.java))
        }
        binding.Selectionsort.setOnClickListener {
            startActivity(Intent(this@srtActivity,selectionActivity::class.java))
        }
        binding.Insertionsort.setOnClickListener {
            startActivity(Intent(this@srtActivity,InsertionActivity::class.java))
        }
    }
}