package coroutines

import junit.framework.Assert.assertEquals
import kotlinx.coroutines.*
import org.junit.Test
import java.util.concurrent.atomic.AtomicInteger

class Tests {
    @Test
    fun givenAsyncCoroutine_whenStartIt_thenShouldExecuteItInTheAsyncWay() {
        //given
        val res = mutableListOf<String>()

        //when
        // will execute synchronously
        runBlocking {
            launch {
                expensiveComputation(res)

            }
            res.add("Hello,")
        }

        //then
        assertEquals(res, listOf("Hello,", "word!"))
    }

    @Test
    fun givenHugeAmountOfCoroutines_whenStartIt_thenShouldExecuteItWithoutOutOfMemory() {
        runBlocking<Unit> {
            //given
            val counter = AtomicInteger(0)
            val numberOfCoroutines = 100_000

            //when
            val jobs = List(numberOfCoroutines) {
                launch {
                    delay(1L)
                    counter.incrementAndGet()
                }
            }
            jobs.forEach { it.join() }

            //then
            assertEquals(counter.get(), numberOfCoroutines)
        }
    }

    @Test
    fun test() {
        val list = List(10) { "New Element" }

        assertEquals(10, list.size)
    }

    @Test
    fun givenCancellableJob_whenRequestForCancel_thenShouldQuit() {
        runBlocking<Unit> {
            //given
            val job = launch(Dispatchers.Default) {
                println("is working")
            }

            delay(10L)

            //when
            //job.cancel()
            //then cancel successfully
        }
    }
    @Test
    fun `givenAsyncAction whenDeclareTimeout thenShouldFinishWhenTimedOut`() {
        runBlocking<Unit> {
            withTimeout(1300L) {
                repeat(1000) { i ->
                    println("Some expensive computation $i ...")
                    delay(500L)
                }
            }
        }
    }
}
