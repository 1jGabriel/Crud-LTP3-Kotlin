package br.com.aluguel.aluguelquadras.banco

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Banco(context: Context) : SQLiteOpenHelper(context, "aluguel.db", null, 1){


    private val CREATE_TABLE = "CREATE TABLE Aluguel (ID INTEGER PRIMARY KEY AUTOINCREMENT, NomeCliente TEXT NOT NULL, Pagamento TEXT, Data TEXT);"

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }
}