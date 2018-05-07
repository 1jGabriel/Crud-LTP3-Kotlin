package br.com.aluguel.aluguelquadras.view.adapter

import android.content.Context

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import br.com.aluguel.aluguelquadras.R
import br.com.aluguel.aluguelquadras.banco.AluguelDAO
import br.com.aluguel.aluguelquadras.banco.model.Aluguel
import br.com.aluguel.aluguelquadras.view.viewholder.AluguelViewHolder
class AluguelAdapter : RecyclerView.Adapter<AluguelViewHolder> {
    private var context: Context
    private var alugueis: ArrayList<Aluguel> = ArrayList()

    constructor(tarefas: ArrayList<Aluguel>, context: Context) {
        this.alugueis = tarefas
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AluguelViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.aluguel_item, parent,false)
        return AluguelViewHolder(view)
    }

    override fun onBindViewHolder(holder: AluguelViewHolder, position: Int) {
        val tarefa = this.alugueis.get(position)
        holder?.let {
            it.bidingView(tarefa)
        }
        holder.btnDelete.setOnClickListener{
            val dao = AluguelDAO(context)
            dao.excluir(alugueis[position].id!!)
            alugueis.remove(alugueis[position])
            notifyItemRemoved(position)
        }
    }

    override fun getItemCount(): Int {
        return alugueis.count()
    }

    fun atualizarAluguel(aluguel: Aluguel) {
        alugueis.set(alugueis.indexOf(aluguel), aluguel)
        notifyItemChanged(alugueis.indexOf(aluguel))
    }

}