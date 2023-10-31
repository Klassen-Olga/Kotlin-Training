package coroutines

import kotlinx.coroutines.*

var acquired = 0

class Resource {
	init {
		acquired++
	} // Acquire the resource

	fun close() {
		acquired--
	} // Release the resource
}


fun main() = runBlocking {

	coroutineScope {
		repeat(10_000) {
			launch {
				var resource: Resource? = null
				withTimeoutOrNull(60) {
					delay(50)
					resource = Resource()
				}
				resource?.close()
			}
		}
	}

	println(acquired)


}