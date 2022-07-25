class Solution {
    fun maxDepth(root: TreeNode?): Int {
        var maxHeight = 0
        var numberOfNodes = 0
        fun inOrder(node: TreeNode?) {

            if (node != null) {
                numberOfNodes += 1
                val beforeBranching = numberOfNodes
                inOrder(node.left)
                numberOfNodes = beforeBranching
                inOrder(node.right)
            } else {
                maxHeight = maxOf(maxHeight, numberOfNodes)
            }
        }

        inOrder(root)
        return maxHeight
    }
}
