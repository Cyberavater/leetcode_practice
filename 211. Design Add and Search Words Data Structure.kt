class Trie {
    val children = hashMapOf<Char, Trie>()
    var tail = false
}

class WordDictionary() {

    private val trie = Trie()

    fun addWord(word: String) {

        var cur = trie
        for (letter in word) {
            if (letter !in cur.children) {
                cur.children[letter] = Trie()
            }
            cur = cur.children[letter]!!
        }
        cur.tail = true
    }

    fun search(word: String): Boolean {

        fun dfs(startingIndex: Int, node: Trie): Boolean {

            var cur = node
            for (letterIndex in startingIndex until word.length) {
                val letter = word[letterIndex]
                if (letter == '.') {
                    for (child in cur.children.values) {
                        if (dfs(letterIndex + 1, child)) {
                            return true
                        }
                    }
                    return false
                } else {
                    if (letter !in cur.children) {
                        return false
                    }
                    cur = cur.children[letter]!!
                }
            }
            return cur.tail
        }
        return dfs(0, trie)
    }

}
