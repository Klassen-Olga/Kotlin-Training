package coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
/*
*
* runBlocking blocks the current thread
* coroutineScope suspends the current thread and releases it for other coroutine
* */
fun main() {
    println("start")

    runBlocking {    // waits till every child is finished

        // coroutine builder
        println("before coroutineScope")
        coroutineScope {    // waits till every child is finished
            launch {
                extracted()

            }
            println("Hello")
        }
        println("after coroutineScope")
    }


    println("end")
}