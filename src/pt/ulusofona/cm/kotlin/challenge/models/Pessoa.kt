package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.PessoaSemCartaException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoNaoEncontradoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.time.LocalDateTime
import java.util.Date

class Pessoa(nome : String, dataDeNascimento: Date) : Movimentavel{
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
        for(veiculo in veiculos) {
            if(veiculo.identificador == identificador) {
                veiculo.dataDeAquisicao = java.sql.Timestamp.valueOf(LocalDateTime.now())
                comprador.comprarVeiculo(veiculo)
                this.veiculos.remove(veiculo)
            }
        }
        throw VeiculoNaoEncontradoException()
    }

    fun moverVeiculoPara(identificador: String, x: Int, y:Int) {
        for (veiculo in veiculos) {
            if (veiculo.identificador == identificador) {
                if (veiculo.requerCarta() and (!this.temCarta())) {
                    throw PessoaSemCartaException()
                } else {
                    veiculo.moverPara(x, y)
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
        this.carta = Carta()
    }

    override fun moverPara(x: Int, y: Int) {
        this.posicao.alterarPosicaoPara(x, y)
    }

    override fun toString(): String {
        return "Pessoa | $nome | $dataDeNascimento | $posicao)"
    }



}