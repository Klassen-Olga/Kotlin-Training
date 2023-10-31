package classes

enum class AccountTypes {

    GOLD {override fun discount() = 15 },
    BRONZE{override fun discount() = 0 },
    SILVER{override fun discount() = 5 };

    abstract fun discount(): Int
}