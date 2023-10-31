fun main() {
    var listOf = listOf("A", "B", "C")
    val month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"


    val toRegex = """
        \d{2} $month \d{4}"""
        .trimIndent().toRegex()

    println(
        toRegex.matches("22 JAN 2024")
    )
    task()
}




fun <T> T.myApply(f: T.() -> Unit): T {
    TODO()
}

fun createString(): String {
    return StringBuilder().myApply {
        append("Numbers: ")
        for (i in 1..10) {
            append(i)
        }
    }.toString()
}

fun createMap(): Map<Int, String> {
    return hashMapOf<Int, String>().myApply {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}




fun<K,V> buildMutableMap(build: HashMap<K,V>.()->Unit):Map<K, V>{
    val hashMap = HashMap<K, V>()
    hashMap.build()
    return hashMap
}

fun usage(): Map<Int, String> {
    return buildMutableMap {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}


fun task(): List<Boolean> {
    val isEven: Int.() -> Boolean = { this%2==0 }
    val isOdd: Int.() -> Boolean = { this%2!=0  }

    val bool=5.isEven()
    return listOf(42.isOdd(), 239.isOdd(), 294823098.isEven())
}


class LazyPropertyy(val initializer: () -> Int) {
    val lazyValue: Int by lazy(initializer)
}


class LazyProperty(val initializer: () -> Int) {
    var value: Int? = null
    val lazy: Int
        get() {
            if (value == null) {
                value = initializer()
            }
            return value!!
        }
}

class PropertyExample() {
    var counter = 0
    var propertyWithCounter: Int? = null
        set(newValue) {
            field=newValue
            counter++}
}

fun doSomethingWithCollection(collection: Collection<String>): Collection<String>? {

    val groupsByLength = collection.groupBy { s -> s.length }

    val maximumSizeOfGroup = groupsByLength.values.map { group -> group.size }.maxOrNull()

    return groupsByLength.values.firstOrNull { group -> group.size==maximumSizeOfGroup }
}


// Find the most expensive product among all the delivered products
// ordered by the customer. Use `Order.isDelivered` flag.
fun findMostExpensiveProductByy(customer: Customer): Product? {
    return customer.orders.filter { it.isDelivered }.flatMap { it.products }.maxByOrNull { it.price }
}

// Count the amount of times a product was ordered.
// Note that a customer may order the same product several times.
fun Shop.getNumberOfTimesProductWasOrderedd(product: Product): Int {
    return this.customers.flatMap { it.orders }.flatMap { it.products }.filter { it == product }.size
}



// Find the most expensive product among all the delivered products
// ordered by the customer. Use `Order.isDelivered` flag.
fun findMostExpensiveProductBy(customer: Customer): Product? {
   return customer.orders.filter { it.isDelivered }.flatMap { it.products }.maxByOrNull { it.price }
}

// Count the amount of times a product was ordered.
// Note that a customer may order the same product several times.
fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    return this.customers.flatMap { it.orders }.flatMap { it.products }.filter { it == product }.size
}



// Return the set of products that were ordered by all customers
fun Shop.getProductsOrderedByAll(): Set<Product> =
    this.customers.map { it.getOrderedProducts() }.reduce{previousAll, element ->previousAll.intersect(element)}

fun Customer.getOrderedProducts(): Set<Product> =
    this.orders.flatMap { it.products }.toSet()

// Return a customer who has placed the maximum amount of orders
fun Shop.getCustomerWithMaxOrders(): Customer? =
    this.customers.maxByOrNull { it.orders.size }

// Return the most expensive product that has been ordered by the given customer
fun getMostExpensiveProductBy(customer: Customer): Product? =
    customer.orders.flatMap{it.products}.maxByOrNull { it.price  }

// Return the sum of prices for all the products ordered by a given customer
fun moneySpentBy(customer: Customer): Double =
    customer.orders.flatMap { it.products }.sumOf { it.price }






fun Shop.getCustomersWithMoreUndeliveredOrders(): Set<Customer> =
    customers.filter {
        val (delivered, undelivered) = it.orders.partition { it.isDelivered }
        undelivered.size > delivered.size
    }.toSet()

// Build a map that stores the customers living in a given city
fun Shop.groupCustomersByCity(): Map<City, List<Customer>> =
    this.customers.groupBy { it.city }

// Build a map from the customer name to the customer
fun Shop.nameToCustomerMap(): Map<String, Customer> =
    this.customers.associateBy{it.name}

// Build a map from the customer to their city
fun Shop.customerToCityMap(): Map<Customer, City> =
    this.customers.associateWith { it.city }

// Build a map from the customer name to their city
fun Shop.customerNameToCityMap(): Map<String, City> =
    this.customers.associateBy(keySelector = {it.name}, valueTransform = {it.city})




// Return true if all customers are from a given city
fun Shop.checkAllCustomersAreFrom(city: City): Boolean =
    this.customers.all { it.city==city }

// Return true if there is at least one customer from a given city
fun Shop.hasCustomerFrom(city: City): Boolean =
    this.customers.any { it.city==city }

// Return the number of customers from a given city
fun Shop.countCustomersFrom(city: City): Int =
    this.customers.filter { it.city==city }.size

// Return a customer who lives in a given city, or null if there is none
fun Shop.findCustomerFrom(city: City): Customer? =
    this.customers.find { it.city==city }



fun Shop.getSetOfCustomers(): Set<Customer> =
    this.customers.toSet()

fun Shop.getCustomersSortedByOrders(): List<Customer> =
    this.customers.sortedByDescending {it.orders.size  }

// Find all the different cities the customers are from
fun Shop.getCustomerCities(): Set<City> =
    this.customers.map { it.city }.toSet()

// Find the customers living in a given city
fun Shop.getCustomersFrom(city: City): List<Customer> =
    this.customers.filter { it.city==city }

data class Shop(val name: String, val customers: List<Customer>)

data class Customer(val name: String, val city: City, val orders: List<Order>) {
    override fun toString() = "$name from ${city.name}"
}
data class Order(val products: List<Product>, val isDelivered: Boolean)
data class Product(val name: String, val price: Double) {
    override fun toString() = "'$name' for $price"
}
data class City(val name: String) {
    override fun toString() = name
}
