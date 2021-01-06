package leetcode;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    public Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode iter = root;
        while(iter != null){
            stack.push(iter);
            iter = iter.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !(stack.isEmpty()); 
    }

    /** @return the next smallest number */
    public int next() {
        if(hasNext()){
           TreeNode top = stack.pop();
           TreeNode iter = top.right;
           while(iter != null){
               stack.push(iter);
               iter = iter.left;
           }
           return top.val;
        }
        
        return Integer.MIN_VALUE;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
