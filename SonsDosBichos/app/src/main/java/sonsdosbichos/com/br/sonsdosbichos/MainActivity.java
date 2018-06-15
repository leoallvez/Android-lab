package sonsdosbichos.com.br.sonsdosbichos;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.util.concurrent.CancellationException;

public class MainActivity extends Activity implements View.OnClickListener {

    private ImageView cao;
    private ImageView vaca;
    private ImageView gato;
    private ImageView leao;
    private ImageView macaco;
    private ImageView ovelha;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });

        cao    = (ImageView) findViewById(R.id.caoId);
        vaca   = (ImageView) findViewById(R.id.vacaId);
        gato   = (ImageView) findViewById(R.id.gatoId);
        leao   = (ImageView) findViewById(R.id.leaoId);
        macaco = (ImageView) findViewById(R.id.macacoId);
        ovelha = (ImageView) findViewById(R.id.ovelhaId);

        cao.setOnClickListener(this);
        vaca.setOnClickListener(this);
        gato.setOnClickListener(this);
        leao.setOnClickListener(this);
        macaco.setOnClickListener(this);
        ovelha.setOnClickListener(this);
    }

    @Override

    public void onClick(View v){


            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.reset();

            switch (v.getId()) {
                case R.id.caoId:
                    play(R.raw.cao);
                    break;
                case R.id.vacaId:
                    play(R.raw.vaca);
                    break;
                case R.id.gatoId:
                    play(R.raw.gato);
                    break;
                case R.id.leaoId:
                    play(R.raw.leao);
                    break;
                case R.id.macacoId:
                    play(R.raw.macaco);
                    break;
                case R.id.ovelhaId:
                    play(R.raw.ovelha);
                    break;
            }
    }

    private void playOld(int id_midia){
        mediaPlayer = MediaPlayer.create(this, id_midia);
        mediaPlayer.start();
    }

    private void play(int id_midia) {
        try {
            AssetFileDescriptor afd = getResources().openRawResourceFd(id_midia);
            if (afd != null) {
                mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                mediaPlayer.prepareAsync();
            }

        } catch (IOException e) {
            Log.e("", e.getMessage());
        }
    }

    @Override
    protected void onStop() {
        if(mediaPlayer != null) {

            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.release();
        }
        super.onStop();
    }

    @Override
    protected void onDestroy() {

        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}
