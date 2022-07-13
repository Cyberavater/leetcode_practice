fun main() {

    val x = listOf(4, 5, 6, 7, 0, 1, 2)
    val v = Solution().search(x.toIntArray(), 0)
    println(v)

}

class Solution {
    fun search(nums: IntArray, target: Int): Int {

        fun reSearch(l: Int, r: Int): Int {
            val midIndex = (l + r) / 2

            if (l <= r) {
                if (nums[midIndex] == target) {
                    return midIndex
                } else {

                    val partitionAtLeft = nums[l] > nums[midIndex]

                    return if (partitionAtLeft) {

                        if (target >= nums[l] || target < nums[midIndex]) {
                            reSearch(l, midIndex - 1)
                        } else {
                            reSearch(midIndex + 1, r)
                        }

                    } else {
                        if (target < nums[l] || target > nums[midIndex]) {
                            reSearch(midIndex + 1, r)
                        } else {
                            reSearch(l, midIndex - 1)
                        }
                    }

                }
            } else {
                return -1
            }
        }

        return reSearch(0, nums.lastIndex)
    }
}
