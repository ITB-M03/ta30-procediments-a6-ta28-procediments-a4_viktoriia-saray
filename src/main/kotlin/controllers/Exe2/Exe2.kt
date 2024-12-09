package controllers.Exe2

import java.util.*

/**
 * Clase de datos que representa un asiento con coordenadas (fila, columna) en la sala.
 */
data class Asiento(var fila: Int, var columna: Int, var reservado: Boolean = false)

/**
 * Función principal del programa.
 * Inicializa la sala, presenta un menú de opciones y maneja las reservas de los asientos.
 */
fun main() {
    val sc: Scanner = abrirScanner().useLocale(Locale.US)

    // Inicializar la sala de cine (20 filas x 15 columnas)
    val sala = inicializarSala()

    // Llamamos a la función que maneja el menú
    mostrarMenu(sala, sc)

    cerrarScanner(sc)
    println("Gràcies per utilitzar el sistema de reserva!")
}

/**
 * @author Viktoriia
 *   @version 1.0
 * Inicializa la sala con 20 filas y 15 columnas, todos los asientos están disponibles (reservados = false).
 */
fun inicializarSala(): Array<Array<Asiento>> {
    return Array(20) { fila ->
        Array(15) { columna ->
            Asiento(fila, columna)
        }
    }
}

/**
 * Abre un objeto Scanner para leer entradas del usuario.
 * @author Viktoriia
 *   @version 1.0
 * @return Un objeto Scanner configurado.
 */
fun abrirScanner(): Scanner {
    return Scanner(System.`in`)
}

/**
 * Cierra el objeto Scanner.
 * @author Viktoriia
 *   @version 1.0
 * @param scanner El objeto Scanner a cerrar.
 */
fun cerrarScanner(scanner: Scanner) {
    scanner.close()
}

/**
 * Muestra todos los asientos disponibles y reservados de la sala.
 * @author Viktoriia
 *   @version 1.0
 * Los asientos reservados se muestran en rojo y los libres en verde.
 */
fun visualizarSala(sala: Array<Array<Asiento>>) {
    println("Sala de cinema:")
    for (fila in sala) {
        for (asiento in fila) {
            if (asiento.reservado) {
                // Rojo para los asientos reservados
                print("\u001B[31mX \u001B[0m")  // Código ANSI para rojo
            } else {
                // Verde para los asientos libres
                print("\u001B[32m_ \u001B[0m")  // Código ANSI para verde
            }
        }
        println()
    }
}

/**
 * Función para buidar (vaciar) la sala, marcando todos los asientos como disponibles.
 * @author Viktoriia
 *   @version 1.0
 */
fun buidarSala(sala: Array<Array<Asiento>>) {
    for (fila in sala) {
        for (asiento in fila) {
            asiento.reservado = false
        }
    }
    println("Sala buidada correctament.")
}

/**
 * Función para reservar un asiento de la sala.
 * @author Viktoriia
 *   @version 1.0
 */
fun reservarAsiento(sala: Array<Array<Asiento>>, sc: Scanner) {
    try {
        print("Introdueix la fila (1-20): ")
        val fila = sc.nextInt() - 1
        print("Introdueix la columna (1-15): ")
        val columna = sc.nextInt() - 1

        if (fila in 0..19 && columna in 0..14) {
            val asiento = sala[fila][columna]
            if (!asiento.reservado) {
                asiento.reservado = true
                println("Seient reservat correctament.")
            } else {
                println("Aquest seient ja està reservat!")
            }
        } else {
            println("Coordenades fora de rang.")
        }
    } catch (e: InputMismatchException) {
        println("Si us plau, introdueix números vàlids.")
    }
}

/**
 * Función recursiva que maneja el menú de opciones.
 * @author Viktoriia
 *   @version 1.0
 */
fun mostrarMenu(sala: Array<Array<Asiento>>, sc: Scanner) {
    println("\nMenú:")
    println("a) Buidar sala")
    println("b) Visualitzar seients disponibles")
    println("c) Reserva de seients")
    println("d) Sortir")
    print("Selecciona una opció: ")

    when (readLine()) {
        "a" -> {
            buidarSala(sala)
            mostrarMenu(sala, sc) // Llamada recursiva
        }
        "b" -> {
            visualizarSala(sala)
            mostrarMenu(sala, sc) // Llamada recursiva
        }
        "c" -> {
            reservarAsiento(sala, sc)
            mostrarMenu(sala, sc) // Llamada recursiva
        }
        "d" -> {
            println("Sortint del sistema...")
        }
        else -> {
            println("Opció no vàlida. Torna a provar.")
            mostrarMenu(sala, sc) // Llamada recursiva
        }
    }
}
