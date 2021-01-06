package interviewbit;

import java.util.ArrayList;
import java.util.Collections;

public class IntBit_ZigZagBT {

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (A == null) return res;

        ArrayList<TreeNode> par = new ArrayList<>();
        par.add(A);
        boolean isLeft = true;

        while (par.size() != 0) {
            ArrayList<TreeNode> child = new ArrayList<>();
            ArrayList<Integer> temp = new ArrayList<>();
            if (isLeft) {
                for (int i = 0; i < par.size(); i++) {
                    TreeNode curr = par.get(i);
                    temp.add(curr.val);
                    //next level is right so we need to add right first, then left
                    if (curr.left != null) child.add(curr.left);
                    if (curr.right != null) child.add(curr.right);
                }
            } else {
                for (int i = par.size() - 1; i >= 0; i--) {
                    TreeNode curr = par.get(i);
                    temp.add(curr.val);
                    if (curr.right != null) child.add(curr.right);
                    if (curr.left != null) child.add(curr.left);
                }
                Collections.reverse(child);
            }
            isLeft = !isLeft;
            par = child;
            res.add(temp);
        }

        return res;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
}
