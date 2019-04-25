package br.com.listadecompras

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Implementado o adaptador;
        val produtoAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        //definindo o adaptador na lista;
        list_view_produtos.adapter = produtoAdapter

        //definindo domouvinte do botão;
        btn_inserir.setOnClickListener {
            val produto = txt_produto.text.toString();
            if(produto.isNotEmpty()) {
                produtoAdapter.add(produto)
                txt_produto.text.clear();
            } else {
                txt_produto.error = "Preencha um valor";
            }
        }
    }
}
