package dominando.android.serializable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_outra.*
import org.parceler.Parcels

class OutraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_outra)

        //val pessoa = intent.getSerializableExtra("pessoa") as Pessoa?

        val pessoa = Parcels.unwrap<Pessoa?>(intent.getParcelableExtra("pessoa"))

        pessoa?.let {
            text_mensagem.text = "Nome: ${pessoa.nome} / Idade: ${pessoa.idade}"
        }

    }
}
