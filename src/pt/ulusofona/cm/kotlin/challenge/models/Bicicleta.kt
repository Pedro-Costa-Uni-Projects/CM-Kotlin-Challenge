package pt.ulusofona.cm.kotlin.challenge.models

class Bicicleta(identificador : String) : Veiculo(identificador) {
    var identificador2 = identificador

    override fun toString(): String {
        return "Bicicleta $identificador2| Veiculo | $this.identificador | $this.posicao | $this.dataDeAquisicao"
    }

}