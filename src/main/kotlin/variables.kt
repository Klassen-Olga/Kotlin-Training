import java.time.LocalDateTime

fun main() {
    booleans()
}

fun immutable() {
    // val is immutable
    val age = 13L
    println(age::class)
}

fun mutable() {
    // var is mutable
    var fullName = "John Doe"
    println(fullName)

    fullName = "Jane Doe"
    println(fullName)
    println(fullName::class)

    var date: LocalDateTime = LocalDateTime.now()
    println(date::class)
}

fun numericals() {
    val active: Byte = 127 // 8-bit signed integer
    val age: Short = 16 // 16-bit signed integer
    val integer: Int = 32 // 32-bit signed integer // 90% of the time
    val long: Long = 64 // 64-bit signed integer

    val float: Float = 32.9F // 32-bit floating point number
    val double: Double = 64.0 // 64-bit floating point number


    // each type can be transformed in another type
    println(float.toInt())

    // cool syntax for large numbers
    val oneMillion = 1_000_000
    println(oneMillion)

    // sugar
    age.plus(1)
    age.minus(1)
    age.times(1)
    age.div(1)

}
fun strings(){
    var fullName: String = "John Doe"
    fullName.lowercase()

    // string templates

    var message:String="""
        Hello World
        This is a multiline string
    """.trimIndent()//removes margins
    println(message)

    message="""
        Hello World
        This is a multiline string
    """.replaceIndent("*) ")//replaces margins
    println(message)

    // string concatenation
    val firstName="John"
    val lastName="Doe"
    val fullName2= "Hello $firstName lovely $lastName lowered case ${firstName.lowercase()}"
    println(fullName2)
}

fun booleans(){
    val isTrue:Boolean=true
    val isFalse:Boolean=false

    //nigates
    println(isTrue.not())
    println(isTrue.not())

}