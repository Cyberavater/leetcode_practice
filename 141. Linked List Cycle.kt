class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun hasCycle(head: ListNode?): Boolean {

        val hashset = hashSetOf<ListNode>()

        var cur = head
        while (cur != null) {
            if (cur in hashset) {
                return true
            }
            hashset.add(cur)
            cur = cur.next
        }
        return false
    }
}
