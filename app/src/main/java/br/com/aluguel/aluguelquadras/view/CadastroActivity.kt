package br.com.aluguel.aluguelquadras.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.aluguel.aluguelquadras.R
import br.com.aluguel.aluguelquadras.banco.AluguelDAO
import br.com.aluguel.aluguelquadras.banco.model.Aluguel
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        btn_cadastrar2.setOnClickListener {
            val aluguel = Aluguel()
            aluguel.pago = switch_pago.isChecked.toString()
            aluguel.cliente = txt_nome_cliente.text.toString()
            aluguel.data = data.text.toString()
            val dao = AluguelDAO(this)
            dao.salvarBanco(aluguel.cliente.toString(), aluguel.pago.toString(), aluguel.data.toString())
            finish()
        }
    }
}