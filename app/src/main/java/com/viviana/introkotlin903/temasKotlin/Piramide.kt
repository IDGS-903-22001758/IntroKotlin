package com.viviana.introkotlin903.temasKotlin

/* practica2 = imprimir una piramide de * segun el numero dado por el usuario
    n=5
    *
    **
    ***
    ****
    *****
    cuando se capture un 0 terminar el programa, utilizando solo do-while

    */
fun main() {
    var num: Int
    do {
        println("Ingrese la cantidad de pisos de la piramide (0 para salir)")
        num = readln().toInt()

        var numH = 0
        do {
            var numV = 0
            do {
                print("*")
                numV++
            } while (numV <= numH)
            println()
            numH++
        } while (numH < num && num != 0)
    } while (num != 0)
    println("Saliendo del programa ^^...")
}