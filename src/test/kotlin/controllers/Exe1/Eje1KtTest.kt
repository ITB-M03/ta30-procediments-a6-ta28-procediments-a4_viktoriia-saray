package org.example.controllers

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Eje1KtTest {
    @Test
    fun testIguals() {
        // Crear dos puntos iguales
        val punt1 = Punt(2.0f, 3.0f)
        val punt2 = Punt(2.0f, 3.0f)

        // Verificar que los puntos son iguales
        assertTrue(iguals(punt1, punt2))

        // Crear un punto diferente
        val punt3 = Punt(3.0f, 4.0f)

        // Verificar que los puntos no son iguales
        assertFalse(iguals(punt1, punt3))
    }

    @Test
    fun translacio() {
        // Crear dos puntos
        val punt1 = Punt(1.0f, 1.0f)
        val punt2 = Punt(2.0f, 3.0f)

        // Realizar la traslación
        translacio(punt1, punt2)

        // Verificar el resultado
        assertEquals(3.0f, punt1.x)
        assertEquals(4.0f, punt1.y)
    }

    @Test
    fun escala() {
        // Crear un punto
        val punt = Punt(2.0f, 3.0f)

        // Realizar el escalado
        escala(punt, 2.0f)

        // Verificar el resultado
        assertEquals(4.0f, punt.x)
        assertEquals(6.0f, punt.y)
    }

}