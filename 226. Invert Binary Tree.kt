class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        fun inOrder(node: TreeNode?) {
            if (node != null) {
                val left = node.left
                node.left = node.right
                node.right = left
                inOrder(node.left)
                inOrder(node.right)
            }
        }
        inOrder(root)

        return root
    }
}
