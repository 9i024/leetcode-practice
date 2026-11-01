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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        else if((p == null && q != null) || (p != null && q == null)) return false;
        Deque<TreeNode> stackP = new ArrayDeque<>();
        Deque<TreeNode> stackQ = new ArrayDeque<>();
        TreeNode dummy = new TreeNode(101);
        stackP.push(p);
        stackQ.push(q);
        while(!stackP.isEmpty() || !stackQ.isEmpty()){
            TreeNode currP = stackP.pop();
            TreeNode currQ = stackQ.pop();
            if(currP.val != currQ.val) return false;
            if(currP.left != null) stackP.push(currP.left);
            else if(currP.val != 101) stackP.push(dummy);

            if(currP.right != null) stackP.push(currP.right);
            else if(currP.val != 101) stackP.push(dummy);

            if(currQ.left != null) stackQ.push(currQ.left);
            else if(currQ.val != 101) stackQ.push(dummy);

            if(currQ.right != null) stackQ.push(currQ.right);
            else if(currQ.val != 101) stackQ.push(dummy);
        }
        return true;
    }
}
