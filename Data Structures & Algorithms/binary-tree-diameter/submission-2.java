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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<TreeNode> list = new ArrayList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        int max = 0;

        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            if(temp.left != null) stack.push(temp.left);
            if(temp.right != null) stack.push(temp.right);
            list.add(temp);
        }
        
        map.put(null, 0);

        for(int i = list.size() - 1; i >= 0; i--){
            TreeNode temp = list.get(i);
            map.put(temp, Math.max(map.get(temp.left), map.get(temp.right)) + 1);
            max = Math.max(max, map.get(temp.left) + map.get(temp.right));
        }
        return max;
    }
}
