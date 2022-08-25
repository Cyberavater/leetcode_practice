class Trie {
    val children = hashMapOf<Char, Trie>()
    var tail = false

    fun addWord(word: String) {
        var cur = this
        for (letter in word) {
            if (letter !in cur.children) {
                cur.children[letter] = Trie()
            }
            cur = cur.children[letter]!!
        }
        cur.tail = true
    }
}

class Solution {

    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {

        val trie = Trie()
        for (word in words) {
            trie.addWord(word)
        }

        val paths = hashSetOf<Pair<Int, Int>>()

        val result = mutableListOf<String>()

        val iSize = board.size
        val jSize = board[0].size

        var word = ""

        fun dfs(path: Pair<Int, Int>, trieNode: Trie) {

            if (path.first != -1
                && path.second != -1
                && path.first != iSize
                && path.second != jSize
            ) {
                val letter = board[path.first][path.second]
                if (path !in paths
                    && letter in trieNode.children
                ) {
                    word += letter

                    val nextNode = trieNode.children[letter]!!
                    if (nextNode.tail) {
                        nextNode.tail = false
                        result.add(word)
                    }


                    paths.add(path)

                    dfs(Pair(path.first + 1, path.second), nextNode)
                    dfs(Pair(path.first - 1, path.second), nextNode)
                    dfs(Pair(path.first, path.second + 1), nextNode)
                    dfs(Pair(path.first, path.second - 1), nextNode)

                    paths.remove(path)

                    word = word.dropLast(1)
                }

            }

        }

        for (i in board.indices) {
            for (j in board[0].indices) {
                dfs(Pair(i, j), trie)
            }
        }
        return result
    }
}
