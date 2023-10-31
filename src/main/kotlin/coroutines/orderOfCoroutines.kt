package coroutines

import kotlinx.coroutines.*
import java.math.BigInteger
import java.util.*
import kotlin.time.measureTime

fun main() = runBlocking {

	// 2 seconds because sequentially
	val time1 = measureTime {
		val one = doSomethingUsefulOne()
		val two = doSomethingUsefulTwo()
		println("${one.plus(two)}")

	}
	println(time1)


	// 1 second because in 2 coroutines in parallel
	val time2 = measureTime {
		val one = async { doSomethingUsefulOne() }
		val two = async { doSomethingUsefulTwo() }
		println("${one.await().plus(two.await())}")

	}
	println(time2)

	// 2 seconds because even if doSomethingUsefulOneInCoroutine doesn;t block the thread
	// the doSomethingUsefulTwoInCoroutine will not be executed before doSomethingUsefulOneInCoroutine is done
	// if we would be in ui, the ui would't be frozen
	val time3 = measureTime {
		val one = doSomethingUsefulOneInCoroutine()
		val two = doSomethingUsefulTwoInCoroutine()
		println("${one.plus(two)}")

	}
	println(time3)


}

// doesn;t block thread, while waiting thread can be used
suspend fun doSomethingUsefulOne(): Int {
	delay(1000L) // pretend we are doing something useful here
	return 13
}

suspend fun doSomethingUsefulTwo(): Int {
	delay(1000L) // pretend we are doing something useful here, too
	return 29
}

// suspend is redundant, because only using it with coroutines context makes it suspendable
suspend fun findBigPrime1(): BigInteger =
	BigInteger.probablePrime(4096, Random())

// suspend is redundant, because only using it with coroutines context makes it suspendable
suspend fun findBigPrime2(): BigInteger = coroutineScope {
	BigInteger.probablePrime(4096, Random())
}

suspend fun doSomethingUsefulOneInCoroutine(): Int = withContext(Dispatchers.Default) {
	delay(1000L) // pretend we are doing something useful here
	13
}

suspend fun doSomethingUsefulTwoInCoroutine(): Int = withContext(Dispatchers.Default) {
	delay(1000L) // pretend we are doing something useful here, too
	29
}