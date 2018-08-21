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
    int maxVal;
    public int maxPathSum(TreeNode A) {
        maxVal = Integer.MIN_VALUE;
        maxPathSumUtil(A);
        return maxVal;
    }
    public int maxPathSumUtil(TreeNode root){
        if(root == null) return 0;
        int left = Math.max(0,maxPathSumUtil(root.left));
        int right = Math.max(0,maxPathSumUtil(root.right));
        maxVal = Math.max(maxVal, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
