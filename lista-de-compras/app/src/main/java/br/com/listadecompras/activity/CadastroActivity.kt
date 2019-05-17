package br.com.listadecompras.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.listadecompra.produtosGlobal
import br.com.listadecompras.R
import br.com.listadecompras.model.Produto
import kotlinx.android.synthetic.main.activity_cadastro.*


class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        btn_inserir.setOnClickListener {
            //Pegando os valores digitado pelo usuario
            val produto = txt_produto.text.toString()
            val qdt = txt_quantidade.text.toString()
            val valor = txt_valor.text.toString()

            if(produto.isNotEmpty().and(qdt.isNotEmpty()).and(valor.isNotEmpty())) {
                //enviar o item para a lista
                produtosGlobal.add(Produto(produto, qdt.toInt(), valor.toDouble()))

                txt_produto.text.clear()
                txt_quantidade.text.clear()
                txt_valor.text.clear()
            }else{
                txt_produto.error = if(txt_produto.text.isNotEmpty()) "Preencha o nome do produtor" else null
                txt_quantidade.error = if(txt_quantidade.text.isNotEmpty()) "Preencha a quantidade" else null
                txt_valor.error = if(txt_valor.text.isNotEmpty()) "Preencha o valor" else null
            }
        }
    }
}
