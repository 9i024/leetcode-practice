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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode pSearch = root, qSearch = root, output = root;
        List<TreeNode> list = new ArrayList<>();

        while(pSearch != p){
            if(p.val < pSearch.val) pSearch = pSearch.left;
            else if(p.val > pSearch.val) pSearch = pSearch.right;
            list.add(pSearch);
        }

        while(qSearch != q){
            if(q.val < qSearch.val) qSearch = qSearch.left;
            else if(q.val > qSearch.val) qSearch = qSearch.right;
            if(list.contains(qSearch) || qSearch == p) output = qSearch;
        }
        return output;
    }
}
