class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        if (nums.size == 1) {
            return mutableListOf(nums.toMutableList())
        }


        for (i in nums.indices) {
            val mutableNums = nums.toMutableList()
            val treeRoot = mutableNums.removeAt(i)
            val perms = permute(mutableNums.toIntArray()).map {
                val perm = it.toMutableList()
                perm.add(treeRoot)
                perm
            }
            result.addAll(perms)
        }

        return result
    }
}
