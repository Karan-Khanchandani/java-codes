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
        int[]pend = new int[1];
        pend[0] = B.size() -1;
        return buildTreeUtil(A,B, 0, A.size() - 1, pend);
    }
    
    public TreeNode buildTreeUtil(ArrayList<Integer> inorder, ArrayList<Integer> postorder, int istart , int iend, int[] pend){
        if(istart > iend ){
            return null;
        }
        int rootVal = postorder.get(pend[0]);
        pend[0]--;
        int inorderidx = istart;
        for(int i = istart; i <= iend; i++){
            if(inorder.get(i) == rootVal){
                inorderidx = i;
                break;
            }
        }
        
        TreeNode root = new TreeNode(rootVal);
        root.right =  buildTreeUtil(inorder,postorder,inorderidx+1, iend, pend);
        root.left = buildTreeUtil(inorder,postorder,istart, inorderidx-1, pend);
        return root;
    }
}
