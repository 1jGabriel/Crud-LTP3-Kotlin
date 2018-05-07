package br.com.aluguel.aluguelquadras.banco

import android.content.Context
import android.database.sqlite.SQLiteDatabase

class Conexao{
    private  var conexao: Conexao? = null
    private lateinit var db: SQLiteDatabase

    constructor(ctx: Context){
        val helper = Banco(ctx)
        db = helper.getWritableDatabase()
    }


    fun getInstance(ctx: Context): Conexao {
        if (conexao == null)
            conexao = Conexao(ctx)
        return conexao!!
    }

    fun getDatabase(): SQLiteDatabase {
        return this.db
    }
}