package classes

fun main(){

    // constructor overloading with default values and named parameters
    // (better solution if we don't need any logic inside constructor)
    val user=User()
    val user1=User(firstName = "John", lastName = "Doe")
    val user2=User(firstName = "Doe")
    val user3=User(lastName = "John")

    println(user)
    println(user1)
    println(user2)
    println(user3)

    // overload constructor
    val employee0 = Employee(id = "29348")
    val employee = Employee(id = "3294", fullname = "Sarah Doe")
    val employee1 = Employee(id = "3294", fullname = "Sarah Doe", teamName = "Backend")

    println(employee0)
    println(employee)
    println(employee1)

    // singleton class
    var nameOfSingletonClass = SingletonClass.name
    SingletonClass.name="new name"
    println(SingletonClass.name)

    // enums
    var bronze = AccountTypes.BRONZE
    bronze.discount()

    AccountTypes.values().forEach { println(it.discount()) }


}

