package leetcode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public static class Status{
        public int numTargetNodes;
        public TreeNode ancestor;
        
        public Status(int n, TreeNode t){
            this.numTargetNodes = n;
            this.ancestor = t;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lowestCommonAncestorHelper(root, p, q).ancestor;
    }
    
    public Status lowestCommonAncestorHelper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return new Status(0, null);
        }
        
        Status leftStatus = lowestCommonAncestorHelper(root.left, p , q);
        if(leftStatus.numTargetNodes == 2){
            return leftStatus;
        }
        
        Status rightStatus = lowestCommonAncestorHelper(root.right, p , q);
        if(rightStatus.numTargetNodes == 2){
            return rightStatus;
        }
        
        int numNodes = leftStatus.numTargetNodes + rightStatus.numTargetNodes + ( (root == p)? 1:0 ) + ((root == q)?1:0);
        return new Status(numNodes, numNodes == 2 ? root : null);
    }
}
