package coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

fun main(){
    runBlocking {
        val job= launch {
            delay(100L)
            println("World!")

        }
        println("Hello")

        job.join() // wait until child coroutine completes
        println("Done")
    }
}
