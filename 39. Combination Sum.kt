class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {

        candidates.sort()

        val result = mutableListOf<List<Int>>()

        val local = mutableListOf<Int>()
        fun dfs(startIndex: Int) {
            for (i in startIndex..candidates.lastIndex) {
                val num = candidates[i]
                local.add(num)
                val sum = local.sum()
                if (sum >= target) {
                    if (sum == target) {
                        result.add(local.toList())
                    }
                    local.removeAt(local.lastIndex)
                    break
                }
                dfs(i)
                local.removeAt(local.lastIndex)
            }

        }
        dfs(0)
        return result
    }
}
