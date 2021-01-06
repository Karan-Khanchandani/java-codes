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
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        if(A.size() == 0 || B.size() == 0) return null;
        return buildTreeUtil(A , B , 0, A.size() - 1, 0, B.size() - 1);
    }
    public TreeNode buildTreeUtil(ArrayList<Integer> preOrder, ArrayList<Integer> inOrder, int pstart, int pend, int istart, int iend){
        if(istart > iend || pstart > pend) return null;
        int rootVal = preOrder.get(pstart);
        int inorderIndex = istart;
        //find root in inorder
        for(int i = istart; i <= iend; i++){
            if(inOrder.get(i) == rootVal){
                inorderIndex = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTreeUtil(preOrder, inOrder, pstart + 1, pstart + inorderIndex - istart, istart, inorderIndex - 1);
        root.right = buildTreeUtil(preOrder, inOrder, pstart + inorderIndex - istart + 1, pend, inorderIndex + 1, iend);
        return root;
    }
}
