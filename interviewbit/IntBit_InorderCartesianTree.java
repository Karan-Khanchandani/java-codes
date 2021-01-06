package interviewbit;

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public TreeNode buildTree(ArrayList<Integer> A) {
        TreeNode root = null;
        if(A.size() == 0) return root;
        root = buildTreeUtil(A, 0, A.size() - 1);
        return root;
    }
    
    public TreeNode buildTreeUtil(ArrayList<Integer> A, int start, int end){
        if(start > end) return null;
        int max = findMax(A,start,end);
        TreeNode root = new TreeNode(A.get(max));
        root.left = buildTreeUtil(A, start, max - 1);
        root.right = buildTreeUtil(A, max + 1, end);
        return root;
    }
    
    public int findMax(ArrayList<Integer> A, int start, int end){
        int maxVal = start;
        for(int i = start; i <= end; i++){
            if(A.get(maxVal) < A.get(i)){
                maxVal = i;
            }
        }
        return maxVal;
    }
}
