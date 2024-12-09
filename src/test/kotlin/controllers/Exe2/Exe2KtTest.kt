package controllers.Exe2

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import java.io.ByteArrayOutputStream
import java.io.PrintStream


class CinemaTest {

    /**
     * Test que verifica la correcta inicialización de la sala.
     */
    @Test
    fun testInicializarSala() {
        // Inicializamos la sala
        val sala = inicializarSala()

        // Verificamos que la sala tenga 20 filas
        assertEquals(20, sala.size, "La sala debe tener 20 filas.")

        // Verificamos que cada fila tenga 15 columnas
        for (fila in sala) {
            assertEquals(15, fila.size, "Cada fila debe tener 15 asientos.")
        }

        // Verificamos que todos los asientos estén disponibles (reservado = false)
        for (fila in sala) {
            for (asiento in fila) {
                assertFalse(asiento.reservado, "El asiento (${asiento.fila + 1}, ${asiento.columna + 1}) debería estar libre al inicializar la sala.")
            }
        }
    }



    /**
     * Test que verifica que la función de vaciar la sala funciona correctamente.
     */
    @Test
    fun testBuidarSala() {
        // Inicializamos la sala
        val sala = inicializarSala()

        // Reservamos algunos asientos
        sala[0][0].reservado = true
        sala[1][1].reservado = true

        // Verificamos que los asientos estén reservados
        assertTrue(sala[0][0].reservado, "El asiento (1, 1) debería estar reservado antes de vaciar la sala.")
        assertTrue(sala[1][1].reservado, "El asiento (2, 2) debería estar reservado antes de vaciar la sala.")

        // Llamamos a la función para vaciar la sala
        buidarSala(sala)

        // Verificamos que todos los asientos estén disponibles
        for (fila in sala) {
            for (asiento in fila) {
                assertFalse(asiento.reservado, "Todos los asientos deberían estar libres después de vaciar la sala.")
            }
        }
    }

    /**
     * Test que verifica que la función de visualizar la sala funciona correctamente.
     * Se ocupan algunos asientos y se verifica que se muestren correctamente como ocupados.
     */
    @Test
    fun testVisualizarSala() {
        // Inicializamos la sala
        val sala = inicializarSala()

        // Reservamos algunos asientos
        sala[0][0].reservado = true
        sala[1][1].reservado = true

        // Capturamos la salida utilizando System.setOut para comprobar que se muestra correctamente
        val outContent = ByteArrayOutputStream()
        System.setOut(PrintStream(outContent))

        // Llamamos a la función para visualizar la sala
        visualizarSala(sala)

        // Verificamos que la salida contiene los caracteres de los asientos ocupados y libres
        val output = outContent.toString()
        assertTrue(output.contains("\u001B[31mX \u001B[0m"), "Los asientos ocupados deben ser mostrados en rojo (X).")
        assertTrue(output.contains("\u001B[32m_ \u001B[0m"), "Los asientos libres deben ser mostrados en verde (_).")
    }
}
