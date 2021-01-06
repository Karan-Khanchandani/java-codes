package interviewbit;

import java.util.Stack;

public class TwoSumBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
            left=null;
            right=null;
        }
    }

    class BSTIterator {
        private Stack<TreeNode> stack;
        private boolean isForward = true;
        public BSTIterator(TreeNode root, boolean flag) {
            this.isForward = flag;
            stack = new Stack<>();
            TreeNode node = root;
            while (node != null) {
                stack.push(node);
                node = isForward ? node.left : node.right;
            }
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }
        public int peek() {
            return stack.peek().val;
        }
        /** @return the next smallest number */
        public int next() {
            TreeNode node = stack.pop();
            int val = node.val;
            node = isForward ? node.right : node.left;
            while (node != null) {
                stack.push(node);
                node = isForward ? node.left : node.right;
            }
            return val;
        }
    }

    public int t2Sum(TreeNode A, int B) {
        BSTIterator left  = new BSTIterator(A, true);
        BSTIterator right = new BSTIterator(A, false);
        while (left.hasNext() && right.hasNext()) {
            int l = left.peek(), r = right.peek();
            if (l >= r)  return 0;
            if (l + r == B) return 1;
            else if (l + r < B)
                left.next();
            else
                right.next();
        }
        return 0;
        
    }
}

