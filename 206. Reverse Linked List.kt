// class ListNode(var `val`: Int) {
//     var next: ListNode? = null
// }

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var cur = head
        var d: ListNode? = null
        var r = cur
        while (cur != null) {
            r = ListNode(cur.`val`)
            r.next = d
            d = r
            cur = cur.next
        }
        return r
    }
}
