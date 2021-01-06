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
    public int height(TreeNode A, int[] ans){
        if(A == null) return 0;
        int left = height(A.left, ans);
        int right = height(A.right, ans);
        if(ans[0] == 1){
            if(Math.abs(left - right) > 1){
                ans[0] = 0;
            }
        }
        return Math.max(left, right) + 1;
    }
    public int isBalanced(TreeNode A) {
        if(A == null) return 1;
        int[] ans = new int[1];
        ans[0] = 1;
        height(A, ans);
        return ans[0];
    }
}
