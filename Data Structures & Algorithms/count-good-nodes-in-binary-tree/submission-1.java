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
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        Pair rootPair = new Pair(root, root.val);
        Deque<Pair> stack = new ArrayDeque<>();
        int max = root.val;
        int res = 0;
        stack.push(rootPair);
        
        while(!stack.isEmpty()){
            Pair pair = stack.pop();
            TreeNode node = pair.node();
            if(node.val >= pair.max()){
                res++;
            }
            max = Math.max(pair.max(), node.val);
            if(node.left != null) stack.push(new Pair(node.left, max));
            if(node.right != null) stack.push(new Pair(node.right, max));
        }
        return res;
    }

    public record Pair(TreeNode node, int max){}
}
