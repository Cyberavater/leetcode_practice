
class Solution {
    fun reorderList(head: ListNode?): Unit {

        if (head != null) {
            var cur = head.next
            val dataList = mutableListOf<Int>()
            while (cur != null) {
                dataList.add(cur.`val`)
                cur = cur.next
            }
            val r = ListNode(-1)
            var rCur = r
            var i = 0
            while (dataList.isNotEmpty()) {
                rCur.next = if (i % 2 == 0) {
                    ListNode(dataList.removeAt(dataList.lastIndex))
                } else {
                    ListNode(dataList.removeAt(0))
                }
                rCur = rCur.next!!
                i++
            }
            head.next = r.next
        }
    }
}
