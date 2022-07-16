class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        nums.sort()

        fun dfs(i: Int, list: MutableList<Int>) {
            if (i == nums.size) {
                result.add(list)
            } else {
                var k = 0
                do {
                    k++
                } while (i + k < nums.size && nums[i + k] == nums[i])
                dfs(i + k, list.toMutableList())
                list.add(nums[i])
                dfs(i + 1, list.toMutableList())
            }
        }

        dfs(0, mutableListOf())

        return result
    }
}
