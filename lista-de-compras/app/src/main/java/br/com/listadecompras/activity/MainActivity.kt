package br.com.listadecompras.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import br.com.listadecompra.toBitmap
import br.com.listadecompras.R
import br.com.listadecompras.adapter.ProdutoAdapter
import br.com.listadecompras.database.database
import br.com.listadecompras.model.Produto
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.db.parseList
import org.jetbrains.anko.db.rowParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.toast
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val produtosAdapter = ProdutoAdapter(this)

        list_view_produtos.adapter = produtosAdapter

        list_view_produtos.setOnItemLongClickListener { adapterView: AdapterView<*>, view: View, position: Int, id: Long ->

            val item = produtosAdapter.getItem(position)

            produtosAdapter.remove(item)
            deletarProduto(item.id)
            toast("item deletado com sucesso")
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

       database?.use{
           select("produtos").exec {
               val parse = rowParser{
                   id: Int,
                       nome: String,
                       quantidade: Int,
                       valor: Double,
                       foto:ByteArray? -> Produto(id, nome, quantidade, valor, foto?.toBitmap())
               }
               val listaProdutos = parseList(parse)
               adapter.clear()
               adapter.addAll(listaProdutos)
               val soma = listaProdutos.sumByDouble { it.valor * it.quantidade }
               val f = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
               txt_total.text = "TOTAL: ${f.format(soma)}"
           }
       }
    }

    private fun deletarProduto(idProduto: Int) {
        database?.use {
            delete("produtos", "id = {id}", "id" to idProduto)
        }
    }

}
