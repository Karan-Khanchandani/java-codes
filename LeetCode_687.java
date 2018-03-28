/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int longestUnivaluePath(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        int res[] = new int[1];
        res[0] = 0;
        dfs(root, res);
        return res[0];
    }
    
    public int dfs(TreeNode root, int res[]){
        int left = (root.left != null) ? dfs(root.left, res) : 0;
        int right = (root.right != null) ? dfs(root.right, res) : 0;
        
        int resl = (root.left != null && root.val == root.left.val) ? left + 1: 0;
        int resr = (root.right != null && root.val == root.right.val) ? right + 1: 0;
        
        res[0] = Math.max(res[0], resl + resr);
        
        return Math.max(resl, resr);
        
    }
}
