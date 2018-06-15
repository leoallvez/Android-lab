package sqlite.com.br.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            //Create Database;
            SQLiteDatabase database = openOrCreateDatabase("app", MODE_PRIVATE, null);

            //Drop table;
            database.execSQL("DROP TABLE IF EXISTS pessoas");
            //Create Table;
            database.execSQL("CREATE TABLE IF NOT EXISTS pessoas(id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3));");
            //Insert in database;
            database.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Marcos', 30);");
            database.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Ana', 10);");
            database.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Paulo', 20);");
            database.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Tiago', 14);");
            database.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Beto', 23);");
            database.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Tatiana', 32);");
            database.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Luiza', 32);");
            database.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Jessica', 34);");

            //Recover data in database
            Cursor cursor = database.rawQuery("SELECT * FROM pessoas WHERE idade > 30;", null);
            int columnIndexId = cursor.getColumnIndex("id");
            int columnIndexNome = cursor.getColumnIndex("nome");
            int columnIndexIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst();

            while (cursor != null) {
                Log.i("RESULT - id", cursor.getString(columnIndexId));
                Log.i("RESULT - nome", cursor.getString(columnIndexNome));
                Log.i("RESULT - idade", cursor.getString(columnIndexIdade));
                cursor.moveToNext();
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
