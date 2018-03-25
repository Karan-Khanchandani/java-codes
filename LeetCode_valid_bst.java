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
    public boolean isValidBST(TreeNode root) {
       return isValidBSTHelper(root, null, null);
    }
    
    public boolean isValidBSTHelper(TreeNode root, Integer low, Integer high){
        if(root == null){
            return true;
        }
        
        return (low == null || root.val > low) && (high == null || root.val < high) && 
            isValidBSTHelper(root.left, low, root.val) && isValidBSTHelper(root.right, root.val, high);
    }
}
