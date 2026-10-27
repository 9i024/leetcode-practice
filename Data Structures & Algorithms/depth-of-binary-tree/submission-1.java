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
    public int maxDepth(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        if(root == null) return 0;
        queue.add(root);
        int depth = 0;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                TreeNode temp = queue.poll();
                if(temp.left != null) queue.offer(temp.left);
                if(temp.right != null) queue.offer(temp.right);
            }
            depth++;
        }
        return depth;
    }
}
