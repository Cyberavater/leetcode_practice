class Solution {

    private val memory = mutableListOf("1")

    private fun convert(numString: String): String {

        val numberList = mutableListOf<String>()

        numString.forEach {

            if (numberList.isNotEmpty() && numberList.last().last() == it) {
                numberList.apply {
                    this[lastIndex] =
                        "${numberList.last().dropLast(1).toInt() + 1}${numberList.last().last()}"
                }
            } else {
                numberList.add("1$it")
            }

        }

        return numberList.joinToString(separator = "")
    }

    fun countAndSay(n: Int): String {

        repeat(n - memory.size) {
            memory.add(convert(memory.last()))
        }

        return memory[n - 1]
    }

}
