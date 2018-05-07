package br.com.aluguel.aluguelquadras.banco

import android.content.ContentValues
import android.content.Context
import br.com.aluguel.aluguelquadras.banco.model.Aluguel
import java.util.ArrayList

class AluguelDAO {

    private val TABLE_CLIENTES = "Aluguel"
    lateinit var conexao: Conexao

    constructor(ctx: Context) {
        conexao = Conexao(ctx).getInstance(ctx)
    }


    fun retornarTodos(): ArrayList<Aluguel> {
        val lista = ArrayList<Aluguel>()
        val cursor = conexao.getDatabase().rawQuery("SELECT * FROM Aluguel", null)
        while (cursor.moveToNext()) {
            val id = cursor.getInt(cursor.getColumnIndex("ID"))
            val nome = cursor.getString(cursor.getColumnIndex("NomeCliente"))
            val pago = cursor.getString(cursor.getColumnIndex("Pagamento"))
            val data = cursor.getString(cursor.getColumnIndex("Data"))
            lista.add(Aluguel(id, nome, pago, data))
        }
        cursor.close()
        return lista
    }

    fun buscarPorNome(nome: String): List<Aluguel> {
        val lista = ArrayList<Aluguel>()
        val cursor = conexao.getDatabase().rawQuery("SELECT * FROM Clientes WHERE NomeCliente = ?", arrayOf(nome))
        while (cursor.moveToNext()) {
            val id = cursor.getInt(cursor.getColumnIndex("ID"))
            val mNome = cursor.getString(cursor.getColumnIndex("NomeCliente"))
            val pago = cursor.getString(cursor.getColumnIndex("Pagamento"))
            val data = cursor.getString(cursor.getColumnIndex("Data"))
            lista.add(Aluguel(id, mNome, pago, data))
        }
        cursor.close()
        return lista
    }

    fun salvarBanco(nome: String, pagamento: String, data: String): Boolean {
        return salvar(0, nome, pagamento, data)

    }

    fun salvar(id: Int, nome: String, pagamento: String, data: String): Boolean {
        val cv = ContentValues()
        cv.put("NomeCliente", nome)
        cv.put("Pagamento", pagamento)
        cv.put("Data", data)
        return if (id > 0)
            conexao.getDatabase().update(TABLE_CLIENTES, cv, "ID=?", arrayOf(id.toString() + "")) > 0
        else
            conexao.getDatabase().insert(TABLE_CLIENTES, null, cv) > 0
    }

    fun excluir(id: Int): Boolean {
        return conexao.getDatabase().delete(TABLE_CLIENTES, "ID=?", arrayOf(id.toString() + "")) > 0
    }
}