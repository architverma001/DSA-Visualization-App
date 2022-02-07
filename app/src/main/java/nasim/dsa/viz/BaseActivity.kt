package nasim.dsa.viz

import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {
    fun alert(msg: String) {
        val builder = AlertDialog.Builder(this)
            .setMessage(msg).setTitle("Result")
            .setPositiveButton("Ok", DialogInterface.OnClickListener { _, _ -> })
        builder.show()
    }


}