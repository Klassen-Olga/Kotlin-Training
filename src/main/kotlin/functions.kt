// functions are objects
fun main() {


    // single expression function
    fun hey() = println("hey")
    hey()

    // scopes
    var age = 12

    fun outputAge() {
        println(age)
    }
    outputAge()

    // named parameters
    // order can ve switched
    // age will be 13 because set
    val john = User(
        isOnline = true,
        firstName = "John",
        lastName = "Doe",
        age = 13
    )
    println(john.toString())

    // vararg -> 0-N values
    // default values allow method overloading
    fun printBooks(name: String="deafult", vararg authorNames:String){
        println("$name has following authors ${authorNames.get(0)}")
    }
    printBooks(
        "Game of thrones",
        "Martin",
        "No one else"
    )


}

fun returnInt(): Int {
    return 1
}

// like void function in java
fun returnUnit(): Unit {}

// function in function
fun firstFunction() {

    fun secondFunction() {
        println("interesting")
    }

    secondFunction()
    secondFunction()
}

class User(var firstName: String, var lastName: String, var age: Int=101, var isOnline: Boolean) {
    override fun toString(): String {
        return "User(firstName='$firstName', lastName='$lastName', age=$age, isOnline=$isOnline)"
    }
}



