package dominando.android.orientacao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private var names = arrayListOf<String>()
    var adapter: ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lastNonConfigurationInstance?.let {
            names = it as ArrayList<String>
        }
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, names)
        lstNames.adapter = adapter
    }
    /**
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState?.putStringArrayList("names_list", names)
    }*/

    override fun onRetainCustomNonConfigurationInstance(): Any = names

    fun btnAddClick(view: View) {
        names.add(edtName.text.toString())
        edtName.text.clear()
        adapter?.notifyDataSetChanged()
    }

}
