package coroutines

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlinx.coroutines.*

/*
* async vs launch: async returns smth, launch is void
*
* run blocking is supposed to be used in main and test
*
* */
val log: Logger = LoggerFactory.getLogger("main")

fun main() {

    // async
    runBlocking {
        val async = async {

            getNumber()
        }
        println(async.await())

    }

    // launch
    runBlocking {
        var launch = launch {
            getNumber()
        }
        // like await
        launch.join()

    }

    // await all
    // with dispatchers all coroutines run on different threads, not just on one

    runBlocking {
        val map: List<Deferred<Int>> = (1..5).map {
            async(Dispatchers.Default) {
                log.info("$it")
                it
            }
        }
        println( map.awaitAll().sum())
    }


}

suspend fun getNumber(): Int {
    delay(10L)
    return 6
}
