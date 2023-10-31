package coroutines

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.*

// once a message is read from channel it disappears from it
fun main() {


	// rendezvous
	runBlocking {
		val channel = Channel<String>()

		launch {
			delay(10L)
			channel.send("Hello")
			channel.send("World")
			println("done")
		}

		launch {
			val receive1 = channel.receive()
			val receive2 = channel.receive()
			val receive3 = channel.receive()
			println("$receive1 $receive2 $receive3")
		}

	}

}