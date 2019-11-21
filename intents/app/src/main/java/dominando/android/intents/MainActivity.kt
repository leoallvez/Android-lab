package dominando.android.intents

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.Settings
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val listView = ListView(this)
        setContentView(listView)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        listView.adapter = adapter
        listView.setOnItemClickListener {_, _, position, _ ->
            openIntentAtPosition(position)
        }
    }

    private fun openIntentAtPosition(position: Int) {
        val uri: Uri?
        val intent: Intent?
        when(position) {
            0 -> {//Abrindo uma URL.
                uri = Uri.parse("http://ngluber.com.br")
                intent = Intent(Intent.ACTION_VIEW, uri)
                openIntent(intent)
            }
            1 -> {//Ralizar chamada.
                uri = Uri.parse("http://+55988109642")
                intent = Intent(Intent.ACTION_DIAL, uri)
                openIntent(intent)
            }
            2 -> {//Pesquisar uma posição no mapa.
                uri = Uri.parse("geo:0,0?q=Rua+Amelia,Recife")
                intent = Intent(Intent.ACTION_VIEW, uri)
                openIntent(intent)
            }
            3 -> {//Abrindo um editor de SMS.
                uri = Uri.parse("sms:123456")
                intent = Intent(Intent.ACTION_VIEW, uri)
                    .putExtra("sms_body", "Corpo do SMS")
                openIntent(intent)
            }
            4 -> {// Compartilhar
                intent = Intent()
                    .setAction(Intent.ACTION_SEND)
                    .putExtra(Intent.EXTRA_TEXT, "Compartilhando via intent")
                    .setType("text/plain")
                openIntent(intent)
            }
            5 -> {// Alarme
                intent = Intent(AlarmClock.ACTION_SET_ALARM)
                    .putExtra(AlarmClock.EXTRA_MESSAGE, "Edudar Android")
                    .putExtra(AlarmClock.EXTRA_HOUR, 19)
                    .putExtra(AlarmClock.EXTRA_MINUTES, 0)
                    .putExtra(
                        AlarmClock.EXTRA_DAYS, arrayListOf(
                            Calendar.MONDAY,
                            Calendar.WEDNESDAY,
                            Calendar.FRIDAY
                        ))
                openIntent(intent)
            }
            6 -> {// Buscado na internet
                intent = Intent(Intent.ACTION_SEARCH)
                    .putExtra(SearchManager.QUERY, "Novatec")
                openIntent(intent)
            }
            7 -> {//Configurção do aparelho
                intent = Intent(Settings.ACTION_SETTINGS)
                openIntent(intent)

            }
            8 -> {// Ação costomizada 1.
                intent = Intent("dominando.android.CUSTOM_ACTION")
                openIntent(intent)
            }
            9 -> {//Ação customizada 2
                uri = Uri.parse("proruto://Notebook/Slim")
                intent = Intent(Intent.ACTION_VIEW, uri)
                openIntent(intent)
            }
            else -> finish()
        }
    }

    private fun openIntent(intent: Intent) {
        if(intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }else{
            Toast.makeText(this, R.string.erro_intent, Toast.LENGTH_LONG).show()
        }
    }

}
