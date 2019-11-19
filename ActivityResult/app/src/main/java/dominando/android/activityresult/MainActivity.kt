package dominando.android.activityresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var state: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnState.setOnClickListener{
            val intent = Intent(this, StatesActivity::class.java)
            intent.putExtra(StatesActivity.EXTRA_STATE, state)
            startActivityForResult(intent,  REQUEST_STATE)
        }
        savedInstanceState?.let {
            state = it.getString(StatesActivity.EXTRA_STATE)
            state?.let { btnState.text = it }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && requestCode == REQUEST_STATE) {
            state = data?.getStringExtra(StatesActivity.EXTRA_RESULT)
            btnState.text = state
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(EXTRA_STATE, state)
    }

    companion object {
        private const val REQUEST_STATE = 1
        private const val EXTRA_STATE = "estado"
    }
}
