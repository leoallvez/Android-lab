package dominando.android.serializable
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.parceler.Parcels

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        abrir_activity.setOnClickListener {
            val intent = Intent(this, OutraActivity::class.java)
            intent.putExtra("pessoa", Parcels.wrap(Pessoa("Fulano", 35)))
            startActivity(intent)
        }
    }
}
