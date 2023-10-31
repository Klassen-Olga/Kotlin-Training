package coroutines

import kotlinx.coroutines.delay



suspend fun expensiveComputation(res: MutableList<String>) {
    delay(1000L)
    res.add("word!")
}