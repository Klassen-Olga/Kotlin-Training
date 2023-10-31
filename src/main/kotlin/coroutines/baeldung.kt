package coroutines

import kotlinx.coroutines.*
import java.lang.Runnable


fun main() {

    // java style
    SimpleThread().start()
    SimpleRunner().run()

    /*
    * coroutines are cheaper as threads
    * */

    // launch new coroutine in global scope (without context not so good), like in threads which always global
    val job = GlobalScope.launch {
        println("${Thread.currentThread()} has run.")
        Thread.sleep(200)

    }
    job.start()

    // instead create coroutines in a context (runBlocking block)
    runBlocking {
        val job = launch {
            println("${Thread.currentThread()} has run.")
            Thread.sleep(300)

        }
    }



    println("End of program")


}



// java style
class SimpleThread:Thread(){
    public override fun run() {
        println("Thread has run")
    }
}
// java style
class SimpleRunner: Runnable{
    override fun run() {
        println("Runner has run")
    }

}

