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
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);

        return max;    
    }

    public int maxDepth(TreeNode node){
        if(node == null) return 0;
        int maxLeft = maxDepth(node.left);
        int maxRight = maxDepth(node.right);

        max = Math.max(maxLeft + maxRight, max);

        return Math.max(maxLeft, maxRight) + 1;
    }
}
