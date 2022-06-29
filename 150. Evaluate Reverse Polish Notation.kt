fun main() {
    val tokens = listOf("10","6","9","3","+","-11","*","/","*","17","+","5","+")
    val v = Solution().evalRPN(tokens.toTypedArray())
    println(v)
}

class Solution {
    fun evalRPN(tokens: Array<String>): Int {

        val numbers = mutableListOf<Int>()

        val operators = hashSetOf("+", "-", "*", "/")

        for (token in tokens) {
            if (token in operators) {
                val a = numbers.removeAt(numbers.lastIndex)
                val b = numbers.removeAt(numbers.lastIndex)
                when (token) {
                    "+" -> numbers.add(b + a)
                    "-" -> numbers.add(b - a)
                    "*" -> numbers.add(b * a)
                    "/" -> numbers.add(b / a)
                }
            } else {
                numbers.add(token.toInt())
            }
        }
        return numbers.last()
    }
}
