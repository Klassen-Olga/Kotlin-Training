package coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
* can suspend in one thread and continue working in another
*
* */
fun main() {
    println("start")

    // coroutine scope
    // the main thread will be blocked
    runBlocking {    // waits till every child is finished
        // coroutine builder
        launch {
            extracted()
        }
        println("Hello")
    }
    println("end")

}

/*
* delay can be used only inside suspend function
* */
suspend fun extracted() {
    delay(1000L)
    println("world")
}


