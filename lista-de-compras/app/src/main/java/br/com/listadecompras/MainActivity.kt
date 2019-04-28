package br.com.listadecompras

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Implementado o adaptador;
        val produtosAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        //definindo o adaptador na lista;
        list_view_produtos.adapter = produtosAdapter

        //definindo domouvinte do botão;
        btn_inserir.setOnClickListener {
            val produto = txt_produto.text.toString();
            if(produto.isNotEmpty()) {
                produtosAdapter.add(produto)
                txt_produto.text.clear();
            } else {
                txt_produto.error = "Preencha um valor";
            }
        }

        list_view_produtos.setOnItemLongClickListener { adapterView: AdapterView<*>, view: View, position: Int, id: Long ->

            val item = produtosAdapter.getItem(position)
            produtosAdapter.remove(item)
            true
        }
    }
}
