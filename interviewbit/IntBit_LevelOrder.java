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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (A == null) return res;
        ArrayList<TreeNode> parent = new ArrayList<>();
        parent.add(A);
        while (parent.size() != 0) {
            ArrayList<Integer> temp = new ArrayList<>();
            ArrayList<TreeNode> child = new ArrayList<>();
            for (int i = 0; i < parent.size(); i++) {
                TreeNode curr = parent.get(i);
                temp.add(curr.val);
                if (curr.left != null) child.add(curr.left);
                if (curr.right != null) child.add(curr.right);
            }
            res.add(temp);
            parent = child;
        }
        return res;
    }
}
