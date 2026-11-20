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
    private int counter = 0;
    private int val = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorderHelper(root, k);
        return val;
    }

    private void inorderHelper(TreeNode node, int k){
        if(node == null) return;
        inorderHelper(node.left, k);
        counter++;
        if(counter == k) val = node.val;
        inorderHelper(node.right, k);
    }
}
