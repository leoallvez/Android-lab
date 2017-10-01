package frasedodia.com.br.frasedodia.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import frasedodia.com.br.frasedodia.R;
import frasedodia.com.br.frasedodia.model.Frase;

public class MainActivity extends AppCompatActivity {

    private TextView textoNovaFrase;
    private TextView autorNovaFrase;
    private LinearLayout linearLayout;
    private List<Frase> frases;
    private String[] cores;
    private String ultimaFrase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frases = new ArrayList<Frase>();
        textoNovaFrase = (TextView) findViewById(R.id.textoNovaFraseId);
        autorNovaFrase = (TextView) findViewById(R.id.autorNovaFraseId);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayoutId);

        carregarFrases();
        cores = getCores();
        selecionarCor();
        selecionarFrase();
        ultimaFrase = "";
    }

    public void onClick(View v) {
        selecionarFrase();
        selecionarCor();
    }

    private void selecionarFrase() {
        Random randomico = new Random();
        int numeroAleatorio = randomico.nextInt(frases.size());
        Frase frase = frases.get(numeroAleatorio);

        while(frase.getTexto().equals(ultimaFrase)) {
            numeroAleatorio = randomico.nextInt(frases.size());
            frase = frases.get(numeroAleatorio);
        }
        ultimaFrase = frase.getTexto();
        textoNovaFrase.setText(frase.getTexto());
        autorNovaFrase.setText("("+frase.getAutor()+")");
    }

    private void selecionarCor() {
        Random randomico = new Random();
        int numeroAleatorio = randomico.nextInt(cores.length);
        linearLayout.setBackgroundColor(Color.parseColor(cores[numeroAleatorio]));

        Log.d("myColor", cores[numeroAleatorio]);
    }

    private String[] getCores() {
        String[] cores = {
            "#1565C0",
            "#00695C",
            "#00E676",
            "#FF6D00",
            "#FF6D00",
            "#1B5E20",
            "#D84315",
            "#E64A19",
            "#FF3D00",
            "#8BC34A",
            "#01579B",
            "#673AB7",
            "#D50000",
            "#9C27B0",
            "#6A1B9A",
            "#880E4F",
            "#AD1457",
            "#B71C1C",
            "#004D40",
            "#512DA8",
        };
        return cores;
    }

    private void carregarFrases() {

        frases.add(new Frase(
                "Tente mover o mundo - o primeiro passo será mover a si mesmo.",
                "Platão"
        ));

        frases.add(new Frase(
                "Fazer grandes coisas é difícil; mas comandar grandes coisas é ainda mais difícil.",
                "Friedrich Nietzsche"
        ));

        frases.add(new Frase(
                "Não ser descoberto numa mentira é o mesmo que dizer a verdade.",
                "Aristóteles Onassis"
        ));

        frases.add(new Frase(
                "Ainda que o bem que persigo esteja distante, contudo existe.",
                "Confúcio"
        ));

        frases.add(new Frase(
                "Estou longe de conhecer o ateísmo na condição de resultado, menos ainda como " +
                        "conhecimento: em mim ele é compreensível na qualidade de instinto.",
                "Friedrich Nietzsche"
        ));

        frases.add(new Frase(
                "Podemos nos defender de um ataque, mas somos indefesos a um elogio.",
                "Sigmund Freud"
        ));

        frases.add(new Frase(
                "Sou exigente com a beleza. Ela tem que vir de dentro.",
                "Moreno Pessoa"
        ));

        frases.add(new Frase(
                "Eu continuo sendo apenas um palhaço, o que já me coloca em nível bem mais alto do " +
                        "que o de qualquer político.",
                "Charles Chaplin"
        ));

        frases.add(new Frase(
                "As espécies que sobrevivem não são as mais fortes, nem as mais inteligentes, mas " +
                        "sim aquelas que se adaptam melhor às mudanças.",
                "Charles Darwin"
        ));

        frases.add(new Frase(
                "Lembre-se: o uso exagerado da língua pode atrofiar o cérebro",
                "Jufras Menhal"
        ));

        frases.add(new Frase(
                "Há sempre alguma loucura no amor. Mas há sempre um pouco de razão na loucura.",
                "Friedrich Nietzsche"
        ));

        frases.add(new Frase(
                "Trate bem as oportunidades. Elas são reservadas e não aparecem pra qualquer um." +
                        " Algumas se ofendem fácil e podem nunca mais voltar. ",
                "Jufras Menhal"
        ));
    }
}
