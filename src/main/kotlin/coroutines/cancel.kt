package coroutines

import kotlinx.coroutines.*

fun main() {
    runBlocking {
        //extractedd()
        cancellableEvenIfHeavyComputation()
    }


}

private suspend fun extractedd() = coroutineScope{
    val job = launch(Dispatchers.Default) {
        repeat(1000) { i ->
            println("job: I'm sleeping $i ...")
            delay(500L)
        }


    }

    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
    //job.cancelAndJoin()
    job.cancel() // cancels the job
    job.join() // waits for job's completion
    println("main: Now I can quit.")
}

// use is active in long computation coroutines
suspend fun cancellableEvenIfHeavyComputation()= coroutineScope{
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (isActive ) { // cancellable computation loop
            // print a message twice a second
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job: I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
    }
    delay(1000L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // cancels the job and waits for its completion
    println("main: Now I can quit.")
}
// use finally instead catch
suspend fun useFinallyToMakeActionsAfterCoroutineCancelled()= coroutineScope{
    val job = launch {
        try {
            repeat(1000) { i ->
                println("job: I'm sleeping $i ...")
                delay(500L)
            }
        } finally {
            println("job: I'm running finally")
        }
    }
    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // cancels the job and waits for its completion
    println("main: Now I can quit.")
}