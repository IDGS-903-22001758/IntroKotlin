package com.viviana.introkotlin903.temasKotlin

fun main(){
    /*
    List
    MutableList
    Set
    MutableSet
    Map
    MutableMap

    */

    var lista = listOf<String>("Lunes", "Martes", "Miercoles")
    println(lista)
    println(lista.size)
    println(lista.get(0))
    println(lista[1])
    println(lista.indexOf("Miercoles"))
    println(lista.first())
    println(lista.last())


    var listaMutable = mutableListOf<String>("Lunes", "Martes", "Miercoles")
    println(listaMutable)
    listaMutable.add("Jueves")
    println(listaMutable)
    listaMutable.removeAt(0)
    println(listaMutable)
    listaMutable.add(0, "Domingo")
    println(listaMutable)
    listaMutable.remove("Miercoles")
    println(listaMutable)
}