class GeneradorSecuencias {
    private lateinit var sec: Sequence<String>

    fun lineSequence(limit: Int = Int.MAX_VALUE) =
            generateSequence { readLine() }.constrainOnce().take(limit)

    fun fraseIncremental(numPalabras: Int) {
        sec = lineSequence().take(numPalabras)
        println("Ingresa $numPalabras palabras:")
        sec?.forEachIndexed { index, palabra ->
            println("Palabra $index: $palabra")
        }
        mostrarSec()
    }

    fun fraseFinal(numPalabras: Int) {
        sec = lineSequence().take(numPalabras)
        println("Ingresa $numPalabras palabras:")
        sec?.forEach { palabra ->
            println("Frase completa: ${sec?.joinToString(" ")}")
        }
    }

    fun getSec(): String {
        return sec?.joinToString(" ") ?: ""
    }

    fun mostrarSec() {
        println("Contenido de sec: ${getSec()}")
    }
}

fun main() {
    val generador = GeneradorSecuencias()

    var numPalabras: Int? = null
    while (numPalabras == null) {
        println("Ingresa el número de palabras de la frase:")
        numPalabras = readLine()?.toIntOrNull()
        if (numPalabras == null) {
            println("Error, se debe ingresar un número entero válido.")
        }
    }

    generador.fraseIncremental(numPalabras)

    numPalabras = null
    while (numPalabras == null) {
        println("Ingresa el número de palabras de la frase final:")
        numPalabras = readLine()?.toIntOrNull()
        if (numPalabras == null) {
            println("Error, se debe ingresar un número entero válido.")
        }
    }

    generador.fraseFinal(numPalabras)
}


