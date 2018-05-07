package br.com.aluguel.aluguelquadras.banco.model

import java.io.Serializable

class Aluguel(
        var id: Int? = null,
        var cliente: String? = null,
        var pago: String? = null,
        var data: String? = null
        ) : Serializable

