package br.com.listadecompras.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import br.com.listadecompras.R
import br.com.listadecompras.model.Produto
import java.text.NumberFormat
import java.util.*

class ProdutoAdapter(contexto: Context) : ArrayAdapter<Produto>(contexto, 0) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?) : View {

        val view: View
        if(convertView != null) {
            view = convertView
        }else{
            view = LayoutInflater.from(context).inflate(R.layout.list_view_item, parent, false)
        }

        val item = getItem(position)
        val produto = view.findViewById<TextView>(R.id.txt_item_produto)
        val quantidade = view.findViewById<TextView>(R.id.txt_item_quantidade)
        val valor = view.findViewById<TextView>(R.id.txt_item_valor)
        val imagem = view.findViewById<ImageView>(R.id.img_foto_produto)

        produto.text = item.nome
        quantidade.text = item.quantidade.toString()
        val f = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
        valor.text = f.format(item.valor.toString())

        if(item.foto != null) {
            imagem.setImageBitmap(item.foto)
        }

        return view
    }

}