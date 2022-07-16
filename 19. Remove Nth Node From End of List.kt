class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {

        var cur = head

        val dummy = ListNode(-1)
        dummy.next = head

        var preDel: ListNode? = dummy
        var delNode = head

        var d = 0
        while (cur != null) {

            if (d >= n) {
                preDel = delNode
                delNode = delNode!!.next
                d--
            }

            cur = cur.next
            d++

        }

        preDel!!.next = delNode?.next
        return dummy.next

    }
}
