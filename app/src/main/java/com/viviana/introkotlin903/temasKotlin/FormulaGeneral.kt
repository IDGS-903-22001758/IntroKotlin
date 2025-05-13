package com.viviana.introkotlin903.temasKotlin

import kotlin.math.sqrt

fun main() {
    var a: Double
    var b: Double
    var c: Double
    var discriminante: Double

    do {
        println("Resolver la formula general")

        println("Ingrese el valor para la variable a: ")
        a = readln().toDouble()

        println("Ingrese el valor para la variable b: ")
        b = readln().toDouble()

        println("Ingrese el valor para la variable c: ")
        c = readln().toDouble()

        discriminante = b * b - 4 * a * c

        if (a == 0.0 && b == 0.0 && c == 0.0) {
            println("Error: los valores de las variables a,b y c no pueden ser cero (no sería ecuación cuadrática)")
        } else if (discriminante < 0) {
            println("Error: El discriminante es negativo ($discriminante). No hay soluciones para estos valores")
            println("Por favor ingrese nuevos valores\n")
        }

    } while (a == 0.0 || discriminante < 0)

    val x1 = (-b + sqrt(discriminante)) / (2 * a)
    val x2 = (-b - sqrt(discriminante)) / (2 * a)

    println("\nSoluciones:")
    println("x1 = $x1")
    println("x2 = $x2")
}