package classes

fun main() {
    var user = User(firstName = "Donee")
    when (user.firstName) {
        "Done" -> println("Done is here")
        "John" -> println("John is here")
        else -> println("Default")
    }

    // either provide all options or else
    val x = AccountTypes.BRONZE
    var message = when (x) {
        AccountTypes.BRONZE -> {
            "This is bronze"
        }

        AccountTypes.SILVER -> {
            "This is silver"
        }

        else -> {
            "Unknown"
        }
    }
}