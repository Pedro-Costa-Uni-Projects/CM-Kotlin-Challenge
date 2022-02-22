package pt.ulusofona.cm.kotlin.challenge.models

class Bicicleta(identificador : String) : Veiculo(identificador) {

    override fun requerCarta(): Boolean {
        return false
    }

    override fun toString(): String {
        val convertString = DateFormattor9000().formattor(this.dataDeAquisicao)
        return "Bicicleta | $identificador | $convertString | ${this.posicao}"
    }

}
