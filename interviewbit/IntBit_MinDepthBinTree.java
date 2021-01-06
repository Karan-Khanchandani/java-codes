package interviewbit;

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public int minDepth(TreeNode A) {
        if(A == null) return 0;
        int left = minDepth(A.left);
        int right = minDepth(A.right);
        
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left, right) + 1;
       
        
    }
}
