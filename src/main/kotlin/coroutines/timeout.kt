package coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

fun main()= runBlocking {


    // if timeout exceeds it will cancel automatically and throw exception, otherwise use withTimeoutOrNull

    var a= getDataFromMicroserviceA()

    if (a==null) println("MicroserviceA is not answering")


}


private suspend fun getDataFromMicroserviceA(): String? {
    return withTimeoutOrNull(1000L) {
        println("Before computation")
        delay(1500)
        println("After computation")
        "Data"

    }
}

///
