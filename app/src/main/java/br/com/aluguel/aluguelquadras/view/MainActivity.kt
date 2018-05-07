package br.com.aluguel.aluguelquadras.view

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import br.com.aluguel.aluguelquadras.R
import br.com.aluguel.aluguelquadras.banco.AluguelDAO
import br.com.aluguel.aluguelquadras.banco.model.Aluguel
import br.com.aluguel.aluguelquadras.view.adapter.AluguelAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView :RecyclerView
    lateinit var adapter : AluguelAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab.setOnClickListener { view ->
            val  intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        configurarRecycler()
    }

    override fun onResume() {
        super.onResume()
        configurarRecycler()
    }


    private fun configurarRecycler() {
        // Configurando o gerenciador de layout para ser uma lista.
        recyclerView = findViewById(R.id.recyclerview)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Adiciona o adapter que irá anexar os objetos à lista.
        val dao = AluguelDAO(this)
        adapter = AluguelAdapter(dao.retornarTodos(), this)
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }
}
