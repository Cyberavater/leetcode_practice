fun main() {

    val x = listOf(11, 13, 15, 17)
    val v = Solution().findMin(x.toIntArray())
    println(v)

}


class Solution {
    fun findMin(nums: IntArray): Int {
        if (nums.size == 1) {
            return nums[0]
        }
        fun reFind(l: Int, r: Int): Int {
            val midIndex = (l + r) / 2
            val circularNext = if (midIndex + 1 < nums.size) midIndex + 1 else 0
            return if (nums[midIndex] > nums[circularNext]) {
                nums[circularNext]
            } else {
                if (nums[l] > nums[midIndex]) {
                    reFind(l, midIndex - 1)
                } else {
                    reFind(midIndex + 1, r)
                }
            }
        }
        return reFind(0, nums.lastIndex)
    }
}
