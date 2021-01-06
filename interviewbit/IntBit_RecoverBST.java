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
    TreeNode prevElement = new TreeNode(Integer.MIN_VALUE), firstElement = null, secondElement = null;

    public ArrayList<Integer> recoverTree(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        recoverTreeUtil(A);
        if (firstElement == null || secondElement == null) return res;
        res.add(secondElement.val);
        res.add(firstElement.val);
        return res;
    }

    public void recoverTreeUtil(TreeNode root) {
        if (root == null) return;
        recoverTreeUtil(root.left);
        //logic
        if (firstElement == null && prevElement.val >= root.val) {
            firstElement = prevElement;
        }

        if (firstElement != null && prevElement.val >= root.val) {
            secondElement = root;
        }

        prevElement = root;
        recoverTreeUtil(root.right);
    }
}
