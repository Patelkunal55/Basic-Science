package com.torque.patel.basicscience

import java.util.ArrayList

fun main(){


        calculateArea(arrayOf(Circle(4.0),Square(5.0),Player("Lionel")))




}

fun calculateArea(shapes: Array<Draggable>){
        for (shape in shapes){
                shape.drag()
        }
}

interface Draggable {
        fun drag()

}


abstract class Shape():Draggable{
        abstract fun area():Double
}

class Circle(val radius: Double): Shape() {
        override fun area():Double = Math.PI * radius * radius
        override fun drag() = println("Circle is dragging")

}

class Square(val side:Double): Shape(){
        override fun area():Double = side * side
        override fun drag() = println("Square is dragging")
}

class Player(val name:String): Draggable{
        override fun drag() {
                println("$name")
        }

        //override fun drag() = println(" $name is dragging")

}







