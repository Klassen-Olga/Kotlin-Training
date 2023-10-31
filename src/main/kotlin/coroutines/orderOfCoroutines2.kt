package coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.time.measureTime

fun main() {
	runBlocking {
		val measureTime = measureTime {
			println(concurrentSum())
		}
		println(measureTime)
	}

}

suspend fun concurrentSum(): Int = coroutineScope {
	val one = async { doSomethingUsefulOne() }
	val two = async { doSomethingUsefulTwo() }
	one.await() + two.await()
}

