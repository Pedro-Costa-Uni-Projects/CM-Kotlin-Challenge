package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.MenorDeIdadeException
import pt.ulusofona.cm.kotlin.challenge.exceptions.PessoaSemCartaException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoNaoEncontradoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.time.LocalDateTime
import java.util.Date

class Pessoa(nome : String, dataDeNascimento: Date){
    var nome = nome
    var dataDeNascimento = dataDeNascimento
    var veiculos : MutableList<Veiculo> = mutableListOf<Veiculo>()
    var carta : Carta? = null
    var posicao = Posicao()

    fun comprarVeiculo(veiculo: Veiculo) {
        this.veiculos.add(veiculo)
    }

    fun pesquisarVeiculo(identificador: String) : Veiculo {
        for (veiculo in veiculos) {
            if(veiculo.identificador == identificador) {
                return veiculo
            }
        }
        throw VeiculoNaoEncontradoException()
    }

    fun venderVeiculo(identificador: String, comprador: Pessoa) {
        var toDelete : Veiculo? = null
        for(veiculo in veiculos) {
            if(veiculo.identificador == identificador) {
                veiculo.dataDeAquisicao = java.sql.Timestamp.valueOf(LocalDateTime.now())
                comprador.comprarVeiculo(veiculo)
                toDelete = veiculo
            }
        }
        var done = this.veiculos.remove(toDelete)
        if(done) {
            return
        } else {
            throw VeiculoNaoEncontradoException()
        }
    }

    fun moverVeiculoPara(identificador: String, x: Int, y:Int) {
        for (veiculo in veiculos) {
            if (veiculo.identificador == identificador) {
                if (veiculo.requerCarta() and (!this.temCarta())) {
                    throw PessoaSemCartaException(this.nome)
                } else {
                    veiculo.posicao.moverPara(x, y)
                }
            }
        }
    }

    fun temCarta() : Boolean {
        if (this.carta != null) {
            return true
        }
        return false
    }

    fun tirarCarta() {
        var diferenca = DateFormattor9000().dateSubtractor(this.dataDeNascimento)
        if(diferenca >= 18) {
            this.carta = Carta()
        } else {
            throw MenorDeIdadeException()
        }
    }

    override fun toString(): String {
        val convertString = DateFormattor9000().formattor(this.dataDeNascimento)
        return "Pessoa | $nome | $convertString | $posicao"
    }



}