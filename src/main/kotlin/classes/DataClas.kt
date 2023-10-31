package classes

fun main(){
    var dataClas1 = DataClas("Lucas")
    var dataClas2 = DataClas("Lucas")

    // true, because data class creates equals and hashcode
    println(dataClas1==dataClas2)
    // do not live in the same memory
    println(dataClas1===dataClas2)

    println(dataClas1)

}
//creates equals and hashcode toString
data class DataClas(val name:String)