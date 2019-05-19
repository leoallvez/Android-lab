package br.com.listadecompras.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class ListaComprasDatabase(context: Context) : ManagedSQLiteOpenHelper(ctx = context, name ="listaCompra.db", version = 1){

    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable("produtos", true,
            "id" to INTEGER +  PRIMARY_KEY + UNIQUE,
            "nome" to TEXT,
            "quantidade" to INTEGER,
            "valor" to REAL,
            "foto" to BLOB
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    companion object {
        private var instance: ListaComprasDatabase? = null

        @Synchronized
        fun getInstance(ctx: Context) : ListaComprasDatabase? {
            if(instance == null) {
                instance = ListaComprasDatabase(ctx.applicationContext)
            }
            return instance
        }

    }
}

val Context.database
        get() = ListaComprasDatabase.getInstance(applicationContext.applicationContext)