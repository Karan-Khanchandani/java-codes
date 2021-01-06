package interviewbit;

/**
 * Definition for binary tree
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    private Stack<TreeNode> st = new Stack<>();

    public Solution(TreeNode root) {
        pushAll(root);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !st.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode tmpNode = st.pop();
        pushAll(tmpNode.right);
        return tmpNode.val;
    }

    void pushAll(TreeNode root) {
        for (; root != null; st.push(root), root = root.left) ;
    }
}

/**
 * Your hackerrank.Solution will be called like this:
 * hackerrank.Solution i = new hackerrank.Solution(root);
 * while (i.hasNext()) System.out.print(i.next());
 */
