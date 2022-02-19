package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.util.Date

abstract class Veiculo(identificador : String) : Motor(){
    var identificador = identificador
    var posicao : Posicao = Posicao()
    var dataDeAquisicao : Date = Date()

    abstract fun requerCarta () : Boolean

    override fun toString(): String {
        return "Veiculo | $identificador | $posicao | $dataDeAquisicao)"
    }


}