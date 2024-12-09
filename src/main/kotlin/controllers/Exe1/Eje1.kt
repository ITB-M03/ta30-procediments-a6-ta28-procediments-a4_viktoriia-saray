package org.example.controllers

import java.util.*

/**
 * @author Viktoriia
 *   @version 1.0
 * Clase de datos que representa un punto con coordenadas x e y.
 */
data class Punt(
    var x: Float,
    var y: Float
)

/**
 *@author Viktoriia
 * @version 1.0
 * Función principal del programa.
 * Inicializa un punto, solicita datos al usuario,
 * realiza operaciones de traslación, escalado y comparación entre puntos.
 */
fun main() {
    val sc: Scanner = obrimScanner().useLocale(Locale.US)

    // Crear un punto con coordenadas ingresadas por el usuario
    val punt = Punt(
        x = definimNombres(sc, "Inserta un número X: "),
        y = definimNombres(sc, "Inserta un número Y: ")
    )

    // Mostrar las coordenadas del punto inicial
    mostraPunt(punt.x, punt.y)

    // Pedir dos números al usuario
    val a = definimNombres(sc, "Inserta un número: ")
    val b = definimNombres(sc, "Inserta otro número: ")

    // Cerrar scanner
    cerrarScanner(sc)

    // Crear otro punto con los valores ingresados
    val punt2 = Punt(a, b)

    // Realizar la traslación del primer punto
    translacio(punt, punt2)

    // Mostrar las coordenadas actualizadas del primer punto
    mostraPunt(punt.x, punt.y)

    // Escalar el primer punto
    escala(punt, a)

    // Mostrar las coordenadas actualizadas después del escalado
    mostraPunt(punt.x, punt.y)

    // Comparar si los dos puntos son iguales
    if (iguals(punt, punt2)) {
        println("Sí")
    } else {
        println("No")
    }
}

/**
 * Abre un objeto Scanner para leer entradas del usuario.
 * @author Viktoriia
 *   @version 1.0
 * @return Un objeto Scanner configurado.
 */
fun obrimScanner(): Scanner {
    val sc: Scanner = Scanner(System.`in`)
    return sc
}
/**
 * Función para cerrar un scanner
 * @author Viktoriia
 * @version 1.0
 */
fun cerrarScanner(scanner: Scanner) {
    scanner.close()
}
/**
 * Solicita al usuario un número con un mensaje personalizado.
 * @author Viktoriia
 *   @version 1.0
 * @param sc Objeto Scanner para leer la entrada.
 * @param msg Mensaje que se mostrará al usuario.
 * @return El número ingresado como Float.
 */
fun definimNombres(sc: Scanner, msg: String): Float {
    print(msg)
    val num: Float = sc.nextFloat()
    return num
}

/**
 * Muestra las coordenadas de un punto en formato (x, y).
 * @author Viktoriia
 *   @version 1.0
 * @param x Coordenada X.
 * @param y Coordenada Y.
 */
fun mostraPunt(x: Float, y: Float) {
    println("(${String.format(Locale.US, "%.6f", x)}, ${String.format(Locale.US, "%.6f", y)})")
}

/**
 * Realiza la traslación de un punto sumando las coordenadas de otro punto.
 * @author Viktoriia
 *   @version 1.0
 * @param punt1 El punto que será trasladado.
 * @param punt2 El punto cuyos valores se sumarán.
 */
fun translacio(punt1: Punt, punt2: Punt) {
    punt1.x += punt2.x
    punt1.y += punt2.y
}

/**
 * Escala un punto multiplicando sus coordenadas por un factor.
 * @author Viktoriia
 *   @version 1.0
 * @param punt El punto que será escalado.
 * @param a El factor de escala.
 */
fun escala(punt: Punt, a: Float) {
    punt.x *= a
    punt.y *= a
}

/**
 * Compara si dos puntos son iguales.
 * @author Viktoriia
 *   @version 1.0
 * @param punt1 Primer punto a comparar.
 * @param punt2 Segundo punto a comparar.
 * @return true si los puntos son iguales, false en caso contrario.
 */
fun iguals(punt1: Punt, punt2: Punt): Boolean {
    return punt1 == punt2
}
