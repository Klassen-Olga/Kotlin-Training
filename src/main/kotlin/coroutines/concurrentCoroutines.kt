import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
    println("start")
    runBlocking {
        twoCoroutines() // first action, completes after all coroutines inside them complete
        println("second line of main thread in runBlocking") // second action
    }
    println("end")

}

suspend fun twoCoroutines()= coroutineScope {

    launch {
        delay(2000L)
        println("thread1")
    }
    launch {
        delay(1000L)
        println("thread2")
    }
    println("last line of main thread in coroutineScope")
}