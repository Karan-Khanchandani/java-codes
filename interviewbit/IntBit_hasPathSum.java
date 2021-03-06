package interviewbit;

/**
 * Definition for binary tree
 * class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) {
 * val = x;
 * left=null;
 * right=null;
 * }
 * }
 */
public class Solution {
    public int hasPathSum(TreeNode A, int B) {

        if (A.left == null && A.right == null && A.val == B) return 1;
        if (A.left == null && A.right == null && A.val != B) return 0;

        int left = (A.left != null) ? hasPathSum(A.left, B - A.val) : 0;
        int right = (A.right != null) ? hasPathSum(A.right, B - A.val) : 0;

        if (left + right > 0) return 1;
        return 0;

    }
}
