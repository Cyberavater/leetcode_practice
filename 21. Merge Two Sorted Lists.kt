class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var cur1 = list1
        var cur2 = list2

        val result = ListNode(-1)
        var tail = result

        while (cur1 != null && cur2 != null) {
            if (cur2.`val` < cur1.`val`) {
                tail.next = cur2
                cur2 = cur2.next
            } else {
                tail.next = cur1
                cur1 = cur1.next
            }
            tail = tail.next!!
        }
        if (cur1 == null && cur2 != null) {
            tail.next = cur2
        } else if (cur1 != null) {
            tail.next = cur1
        }
        return result.next
    }
}
