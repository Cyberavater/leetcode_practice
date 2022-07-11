class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {

        val low = 0
        val m = matrix.size
        val n = matrix[0].size
        val high = m * n - 1

        fun bSearch(l: Int, h: Int): Boolean {
            if (l <= h) {
                val mid = (l + h) / 2
                val a = mid / n
                val b = mid % n
                val midElement = matrix[a][b]
                return if (target == midElement) {
                    true
                } else {
                    if (target < midElement) {
                        bSearch(l, mid - 1)
                    } else {
                        bSearch(mid + 1, h)
                    }
                }
            } else {
                return false
            }
        }
        return bSearch(low, high)
    }
}
