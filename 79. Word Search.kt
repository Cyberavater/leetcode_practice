

class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {

        val maxI = board.lastIndex
        val maxJ = board[0].lastIndex

        val paths = hashSetOf<Pair<Int, Int>>()

        fun dfs(path: Pair<Int, Int>, letterIndex: Int): Boolean {

            if (letterIndex == word.length) {
                return true
            }
            if (path.first < 0
                || path.second < 0
                || path.first > maxI
                || path.second > maxJ
                || path in paths
                || board[path.first][path.second] != word[letterIndex]
            ) {
                return false
            }

            paths.add(path)
            val r = (dfs(Pair(path.first + 1, path.second), letterIndex + 1)
                    || dfs(Pair(path.first - 1, path.second), letterIndex + 1)
                    || dfs(Pair(path.first, path.second + 1), letterIndex + 1)
                    || dfs(Pair(path.first, path.second - 1), letterIndex + 1)
                    )
            paths.remove(path)
            return r
        }

        for (i in board.indices){
            for (j in board[0].indices){
                if (dfs(Pair(i,j), 0)){
                    return true
                }
            }
        }
        return false
    }
}
