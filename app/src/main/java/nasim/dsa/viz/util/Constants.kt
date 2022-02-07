package nasim.dsa.viz.util

import kotlin.random.Random

class Constants {
    companion object {
        fun randomArr(size: Int = 25, from: Int=0, to: Int=100) = IntArray(size) {
            Random.nextInt(to - from) + from
        }.asList()
    }
}