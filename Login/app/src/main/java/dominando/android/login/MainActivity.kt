package dominando.android.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_entrar.setOnClickListener {

            txt_login.error = null
            txt_password.error = null

            val login = txt_login.editText?.text.toString()
            val password = txt_password.editText?.text.toString()

            if(login.isNullOrEmpty()) {
                txt_login.error = "Campo de login deve ser preenchido"
            }

            if(password.isNullOrEmpty()) {
                txt_password.error = "Campo de senha deve ser preenchido"
            }
        }

    }
}
