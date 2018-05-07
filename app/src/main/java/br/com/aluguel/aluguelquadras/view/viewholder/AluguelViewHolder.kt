package br.com.aluguel.aluguelquadras.view.viewholder

import android.view.View
import android.support.v7.widget.RecyclerView
import br.com.aluguel.aluguelquadras.banco.model.Aluguel
import kotlinx.android.synthetic.main.aluguel_item.view.*

class AluguelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val nome = itemView.nomeCliente
    val data = itemView.data_hora
    val pago = itemView.switch_pago
    val btnDelete = itemView.btn_delete

    fun bidingView(aluguel: Aluguel) {
        this.nome.text = aluguel.cliente!!
        this.data.text = aluguel.data!!
        this.pago.isChecked = true
    }
}
