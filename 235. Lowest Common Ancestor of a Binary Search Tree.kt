class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {

        val j:Int
        val k:Int
        if (p!!.`val` < q!!.`val`){
            j = p.`val`
            k = q.`val`
        }else{
            k = p.`val`
            j = q.`val`
        }
        fun sideCheck(node: TreeNode?): TreeNode? {
            return if (node != null) {
                val a = j <= node.`val`
                val b = k >= node.`val`
                if (a && b) {
                    node
                } else if (!b) {
                    sideCheck(node.left)
                } else {
                    sideCheck(node.right)
                }
            } else {
                null
            }
        }
        return sideCheck(root)
    }
}
