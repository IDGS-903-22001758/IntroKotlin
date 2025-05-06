package com.viviana.introkotlin903.temasKotlin

fun main(){
    do{
    println("Seleccione el numero de la operacion que desee realizar" +
            "\n 1.- suma" +
            "\n 2.- resta" +
            "\n 3.- multiplicacion" +
            "\n 4.- division" +
            "\n 5.- salir")
    val operacion = readln().toInt()

    if(operacion == 1){
        println("suma")
        println("ingrese un numero")
        val numero1= readln().toInt()
        println("ingrese otro numero")
        val numero2= readln().toInt()
        val resultado= numero1 + numero2
        println("el resultado de la suma de $numero1 mas $numero2 es $resultado")
    }
    if(operacion == 2){
        println("resta")
        println("ingrese un numero")
        val numero1= readln().toInt()
        println("ingrese otro numero")
        val numero2= readln().toInt()
        val resultado= numero1 - numero2
        println("el resultado de la resta de $numero1 menos $numero2 es $resultado")
    }
    if(operacion == 3){
        println("multiplicacion")
        println("ingrese un numero")
        val numero1= readln().toInt()
        println("ingrese otro numero")
        val numero2= readln().toInt()
        val resultado= numero1 * numero2
        println("el resultado de la multiplicacion de $numero1 por $numero2 es $resultado")
    }
    if(operacion == 4){
        println("division")
        println("ingrese un numero")
        val numero1= readln().toInt()
        println("ingrese otro numero")
        val numero2= readln().toInt()
        val resultado= numero1 / numero2
        println("el resultado de la division de $numero1 entre $numero2 es $resultado")
    }else{
        println("...")
    }
    }while (operacion != 5);

}