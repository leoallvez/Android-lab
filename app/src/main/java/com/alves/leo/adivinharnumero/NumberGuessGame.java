package com.alves.leo.adivinharnumero;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NumberGuessGame extends AppCompatActivity {

    private EditText inputGuess;
    private TextView inputMessage;
    private int secretNumber;
    private boolean gameIsFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_guess_game);

        inputGuess = (EditText) findViewById(R.id.inputGuess);
        inputMessage = (TextView) findViewById(R.id.inputMessage);

        Button btnNewGame = (Button) findViewById(R.id.new_game);
        btnNewGame.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                actionNewGame();
            }
        });

        Button btnGuess = (Button) findViewById(R.id.btnGuess);
        btnGuess.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                processGuess();
            }
        });

        newGame();
    }

    private void processGuess() {
        String strGuess = inputGuess.getText().toString();
        inputGuess.setText("");
        // Verificando se o input está vázio
        if(strGuess.length() == 0) {
            return;
        }

        int guess = Integer.valueOf(strGuess);

        if(guess > secretNumber) {
            inputMessage.setText(R.string.message_high);
        }else if(guess < secretNumber) {
            inputMessage.setText(R.string.message_low);
        }else {
            inputMessage.setText(R.string.message_win);
            gameIsFinished = true;
            newGame();
        }
    }

    private void actionNewGame() {
        if(gameIsFinished) {
            newGame();
            return;
        }

        new AlertDialog.Builder(this)
                .setMessage(R.string.confirm_new_game)
                .setCancelable(false)
                .setNegativeButton(R.string.no, null)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       newGame();
                    }
                }).show();
    }

    private void newGame() {
        secretNumber = (int) (Math.random() * 100);
        inputMessage.setText(R.string.inputMessage);
        inputGuess.setText("");
        gameIsFinished = false;
    }
}
