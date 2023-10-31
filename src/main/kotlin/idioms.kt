import java.lang.IllegalArgumentException
import java.nio.file.Files
import java.nio.file.Path


fun main() {
    // check the presence of element
    val strings = mutableListOf("A", "B")
    if ("A" in strings) println("Is there")

    val users = mutableListOf(User1("John"), User1("Lorkh"))
    if (User1("John") in users) println("Is there")

    //read only map
    val map = mapOf(1 to 3)

    // access
    println(map[1])

    // traverse
    for ((k, v) in map) {
        println("$k -> $v")
    }

    // extend behaviour of everything!!!!
    var myString = "My name is Olga"
    myString.beautifulBehaviour()
    println(myString.beautifulBehaviour())

    // lazy
    val lazy: String by lazy {
        println("calculated")
        "lazy"
    }
    println(lazy)

    //abstract class
    var impl = object : MyAbstractClass() {
        override fun doSmth() {
            TODO("Not yet implemented")
        }

    }
    // not null else
    var a = mutableListOf("A")

    a?.size ?: "empty"
    // run this code block if null
    a?.size ?: run {
        "empty"
    }
    a?.size ?: throw RuntimeException("error")
    // execute this if not null
    a?.size.let {
        //code to run
    }

    // cool try catch
    val result = try {
        "lala"
    }catch (e: RuntimeException){
        throw IllegalArgumentException(e)
    }
    println(result)



    // inline functions
    fun answer()={
        "whole"//return whole
    }

    // using multiple methods on an object
    var turtle = Turtle()
    // instead of
    turtle.turn(90.0)
    turtle.penDown()
    turtle.forward(100.0)
    turtle.penUp()

    // this
    with(turtle){
        turn(90.0)
        penDown()
        penUp()
    }

    // files
    var newBufferedReader = Files.newBufferedReader(Path.of("/my.txt"))
    newBufferedReader.use { // try with resources
        it.readLine()
    }


}

fun String.beautifulBehaviour(): String {
    return this.replace(" ", " beauty ")
}

data class User1(var name: String)

abstract class MyAbstractClass() {
    abstract fun doSmth()
}

class Turtle {
    fun penDown(){}
    fun penUp(){}
    fun turn(degrees: Double){}
    fun forward(pixels: Double){}
}

