package br.com.listadecompras.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.listadecompras.R
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        btn_inserir.setOnClickListener {
            /**
            val produto = txt_produto.text.toString();
            if(produto.isNotEmpty()) {
            produtosAdapter.add(produto)
            //txt_produto.text.clear();
            } else {
            txt_produto.error = "Preencha um valor";
            }
            */
        }
    }
}
