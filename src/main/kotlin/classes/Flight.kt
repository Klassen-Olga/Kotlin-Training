package classes

class Flight(var number: Int) {
    // says to kotlin, this var will be intialized, otherwise need to be initialized
    lateinit var destinationCountry: String
}