class Solution {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        fun preOrderBi(node1: TreeNode?, node2: TreeNode?): Boolean {
            return if (node1 != null && node2 != null) {
                node1.`val` == node2.`val` && preOrderBi(node1.left, node2.left) && preOrderBi(node1.right, node2.right)
            } else node1 == null && node2 == null
        }
        return preOrderBi(p, q)
    }
}
