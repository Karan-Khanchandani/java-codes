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
    
    public static class BalanceWithHeight{
        public boolean balanced;
        public int height;
        
        public BalanceWithHeight(boolean b, int h){
            this.balanced = b;
            this.height = h;
        }
    }
    public boolean isBalanced(TreeNode root) {
        return isBalancedHelper(root).balanced;
    }
    
    public BalanceWithHeight isBalancedHelper(TreeNode root){
        if(root == null){
            return new BalanceWithHeight(true, 0);
        }
        
        BalanceWithHeight left = isBalancedHelper(root.left);
        BalanceWithHeight right = isBalancedHelper(root.right);
        
        if(left.balanced && right.balanced){
            if(Math.abs(left.height - right.height) <= 1){
                return new BalanceWithHeight(true, Math.max(left.height, right.height) + 1);
            }
        }
        return new BalanceWithHeight(false, Math.max(left.height, right.height) + 1);
        
    }
}
