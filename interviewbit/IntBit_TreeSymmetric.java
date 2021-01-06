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
    public int isSymmetric(TreeNode A) {
        return isSymmetricUtil(A, A);
    }

    public int isSymmetricUtil(TreeNode A, TreeNode B) {
        if (A == null && B == null) return 1;
        if (A == null && B != null) return 0;
        if (A != null && B == null) return 1;

        int left = isSymmetricUtil(A.left, B.right);
        int right = isSymmetricUtil(A.right, B.left);

        if (left == 1 && right == 1 && A.val == B.val) return 1;
        return 0;
    }
}
