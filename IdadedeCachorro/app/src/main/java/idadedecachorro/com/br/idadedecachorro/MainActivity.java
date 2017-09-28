package idadedecachorro.com.br.idadedecachorro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText idade;
    private TextView displayIdade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idade = (EditText) findViewById(R.id.editTextIdadeId);
        displayIdade = (TextView) findViewById(R.id.textViewIdade);
    }

    public void calcular(View v) {

        String idadeString = idade.getText().toString();

        if(!idadeString.isEmpty()) {

            int idadeInt = Integer.parseInt(idadeString);
            displayIdade.setText("A idade humana do cachorro é: " + idadeInt * 15 + " anos");
        }
    }


}
