package pt.ulusofona.cm.kotlin.challenge.models

class Carro(identificador : String, motor : Motor) : Veiculo(identificador){
    var identificador2 = identificador
    var motor = motor

    override fun toString(): String {
        return "Carro | $identificador2 | $motor | Veiculo | $this.identificador | $this.posicao | $this.dataDeAquisicao"
    }

}