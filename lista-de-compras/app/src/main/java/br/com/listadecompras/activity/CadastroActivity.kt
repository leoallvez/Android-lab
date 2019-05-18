package br.com.listadecompras.activity

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.listadecompra.produtosGlobal
import br.com.listadecompras.R
import br.com.listadecompras.model.Produto
import kotlinx.android.synthetic.main.activity_cadastro.*


class CadastroActivity : AppCompatActivity() {

    var imageBitMap: Bitmap? = null

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
                produtosGlobal.add(Produto(produto, qdt.toInt(), valor.toDouble(), imageBitMap))

                txt_produto.text.clear()
                txt_quantidade.text.clear()
                txt_valor.text.clear()
            }else{
                txt_produto.error = if(txt_produto.text.isNotEmpty()) "Preencha o nome do produtor" else null
                txt_quantidade.error = if(txt_quantidade.text.isNotEmpty()) "Preencha a quantidade" else null
                txt_valor.error = if(txt_valor.text.isNotEmpty()) "Preencha o valor" else null
            }
        }

        img_foto_produto.setOnClickListener {
            abrirGaleria()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if((requestCode == COD_IMAGEM).and(resultCode == Activity.RESULT_OK)) {
            if(data != null) {
                //lendo a URI com a imagem.
                val imputStream = contentResolver.openInputStream(data.data)
                //transformando o resultado em bitmap.
                imageBitMap = BitmapFactory.decodeStream(imputStream)
                //Exibir a imagem no aplicativo.
                img_foto_produto.setImageBitmap(imageBitMap)
            }
        }
    }

    fun abrirGaleria() {
        //definindo a ação de conteúdo.
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        //definindo filtro para imagens
        intent.type = "image/*"
        //inicializando a activity com resultado
        startActivityForResult(Intent.createChooser(intent, "Selecione uma imagem"), COD_IMAGEM)
    }

    companion object {
        val COD_IMAGEM = 101
    }
}
