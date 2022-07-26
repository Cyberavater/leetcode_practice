class Solution {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        fun checkForSub(tree: TreeNode?): Boolean {
            return if (subRoot == null) {
                tree == null
            } else {
                if (tree != null) {
                    if (tree.sameAs(subRoot)) {
                        true
                    } else {
                        checkForSub(tree.left) || checkForSub(tree.right)
                    }
                } else {
                    false
                }
            }
        }
        return checkForSub(root)
    }

}


fun TreeNode?.sameAs(node: TreeNode?): Boolean {
    return if (this != null && node != null) {
        if (this.`val` != node.`val`) {
            false
        } else {
            this.left.sameAs(node.left) && this.right.sameAs(node.right)
        }
    } else this == null && node == null
}
