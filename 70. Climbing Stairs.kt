class Solution {
    fun climbStairs(n: Int): Int {

        val rMap = hashMapOf(
            1 to 1,
            2 to 2,
            3 to 3
        )

        fun rC(x: Int): Int {
            return if (x in rMap) {
                rMap[x]!!
            } else {
                val g = rC(x - 1) + rC(x - 2)
                rMap[x] = g
                g
            }

        }
        return rC(n)
        
    }
}
