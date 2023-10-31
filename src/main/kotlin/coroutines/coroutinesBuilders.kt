package coroutines

import kotlinx.coroutines.*
import kotlin.time.measureTime

fun main() {
	// 3 secs
	val time1 = measureTime {
		runBlocking {
			delay(1000L)
			println("World!")
		}
		runBlocking {
			delay(1000L)
			println("World!")
		}
		runBlocking {
			delay(1000L)
			println("World!")
		}
		println("Hello,")
	}
	println(time1)

	// 3 sec because coroutinescope
	val time2 = measureTime {
		runBlocking {
			coroutineScope {
				launch {
					delay(1000L)
					println("World!")
				}
			}
			coroutineScope {
				launch {
					delay(1000L)
					println("World!")
				}
			}
			coroutineScope {
				launch {
					delay(1000L)
					println("World!")
				}
			}
		}

	}
	println(time2)

	// 1 sec
	val time3 = measureTime {
		runBlocking {
			launch {
				delay(1000L)
				println("World!")
			}

			launch {
				delay(1000L)
				println("World!")
			}

			launch {
				delay(1000L)
				println("World!")
			}
		}


	}
	println(time3)

	// 1 sec
	val time4 = measureTime {
		runBlocking {
			val async = async {
				delay(1000L)
				println("World!")
			}

			val asyn2 = async {
				delay(1000L)
				println("World!")
			}

			val asyn3 = async {
				delay(1000L)
				println("World!")
			}
			async.await()
			asyn2.await()
			asyn3.await()

		}
	}
	println(time4)

	// 3 sec
	val time5 = measureTime {
		runBlocking {
			val async = async {
				delay(1000L)
				println("World!")
			}
			async.await()

			val asyn2 = async {
				delay(1000L)
				println("World!")
			}
			asyn2.await()

			val asyn3 = async {
				delay(1000L)
				println("World!")
			}
			asyn3.await()

			withContext(Dispatchers.Default){

			}
		}
	}
	println(time5)

}