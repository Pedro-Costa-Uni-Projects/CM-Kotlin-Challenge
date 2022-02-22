package pt.ulusofona.cm.kotlin.challenge

import pt.ulusofona.cm.kotlin.challenge.models.*
import java.time.LocalDateTime

fun main() {
    /*Escrever aqui o codigo   */
    var pessoa = Pessoa("Pedro", java.sql.Timestamp.valueOf(LocalDateTime.now()))
    pessoa.carta = Carta()
    pessoa.comprarVeiculo(Carro("id-123", Motor(20,20)))
    print(pessoa.pesquisarVeiculo("id-123").toString())

}