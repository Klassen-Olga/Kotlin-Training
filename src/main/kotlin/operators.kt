fun main(){

    var name1="John"
    var name2="John"

    // .equals is not respected :D
    // == calls .equals || opposite !=
    // === compares if allocated at the same memory address || opposite !==


    // true, true
    println(name2 == name1)
    println(name2 === name1)

    // true, true
    var a=14
    var b=14
    println(a==b)
    println(a===b)

    // false, false
    var personA=Person("A")
    var personB=Person("A")
    println(personA == personB)
    println(personA===personB)

    // true, false
    var employeeA=Employee("A")
    var employeeB=Employee("A")
    println(employeeA == employeeB)
    println(employeeA===employeeB)

}

class Person(var fullName: String)

class Employee(var fullName: String){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

         other as Employee
         if (fullName != other.fullName) return false
        // the same as
        if (other is Employee) {
            if (fullName != other.fullName) return false
        }

        return true
    }

    override fun hashCode(): Int {
        return fullName.hashCode()
    }
}