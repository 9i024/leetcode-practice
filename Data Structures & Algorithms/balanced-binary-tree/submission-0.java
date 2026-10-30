/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private boolean balanced = true;

    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return balanced;
    }

    private int maxDepth(TreeNode node){
        if(node == null) return 0;
        if(Math.abs(maxDepth(node.left) - maxDepth(node.right)) > 1) balanced = false;
        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }
}
