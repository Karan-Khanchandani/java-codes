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
    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        if (A == null) return res;
        Stack<TreeNode> st = new Stack<>();
        st.push(A);
        while (!st.isEmpty()) {
            TreeNode tp = st.pop();
            res.add(tp.val);
            if (tp.right != null) st.push(tp.right);
            if (tp.left != null) st.push(tp.left);
        }
        return res;
    }
}
