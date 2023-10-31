fun main() {


    // person2 is not nullable
    var person2: Person1 = Person1("boo")

    // person is nullable
    var person1: Person1? = Person1("boo")
    person1=null
    println(person1)

    // safe call
    // if person1 is null, then return null and don;t call full name
    println(person1?.fullName)
    // doesn't need null check
    println(person2.fullName)

    // the same as in java
    if (person1!=null) println(person1.fullName)

    // chain null check
    // both person and fullname are checked. Only if both are not null, the length will be called
    val length = person1?.fullName?.length

    val length1: Int = if(person1!=null && person1.fullName!=null) person1.fullName.length else 0
    //the same as
    // ?: elvis operator
    // x ?: y -> if x null, return y
    val length2: Int = person1?.fullName?.length ?: 0
}

class Person1(var fullName: String)