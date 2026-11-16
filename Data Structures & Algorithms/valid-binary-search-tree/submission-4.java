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
    public boolean isValidBST(TreeNode root) {
        return isValidChecker(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidChecker(TreeNode root, int lowerLimit, int upperLimit){
        if(root == null) return true;
        if(root.val <= lowerLimit || root.val >= upperLimit) return false;
        return isValidChecker(root.left, lowerLimit, root.val) && isValidChecker(root.right, root.val, upperLimit);
    }
}
