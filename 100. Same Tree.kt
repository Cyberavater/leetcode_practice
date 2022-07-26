class Solution {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        fun preOrderBi(node1: TreeNode?, node2: TreeNode?): Boolean {
            if (node1 != null && node2 != null) {
                if (node1.`val` != node2.`val`) {
                    return false
                }
                return preOrderBi(node1.left, node2.left) && preOrderBi(node1.right, node2.right)
            } else return node1 == null && node2 == null
        }
        return preOrderBi(p, q)
    }
}
