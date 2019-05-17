package br.com.listadecompras.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import br.com.listadecompra.produtosGlobal
import br.com.listadecompras.R
import br.com.listadecompras.adapter.ProdutoAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //val produtosAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)

        val produtosAdapter = ProdutoAdapter(this)

        list_view_produtos.adapter = produtosAdapter
        produtosAdapter.addAll(produtosGlobal)

        list_view_produtos.setOnItemLongClickListener { adapterView: AdapterView<*>, view: View, position: Int, id: Long ->

            val item = produtosAdapter.getItem(position)
            produtosAdapter.remove(item)
            true
        }

        btn_adicionar.setOnClickListener{
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        val adapter = list_view_produtos.adapter as ProdutoAdapter
        adapter.clear()
        adapter.addAll(produtosGlobal)
    }
}
