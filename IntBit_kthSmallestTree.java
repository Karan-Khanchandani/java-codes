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
    public int kthsmallest(TreeNode A, int B) {
       ArrayList<Integer> res = new ArrayList<>();
       kthsmallestUtil(A,B,res);
       return res.get(B-1);
    }
    
    public void kthsmallestUtil(TreeNode A, int B, ArrayList<Integer> list){
        if(A == null){
           return;
        }
        kthsmallestUtil(A.left, B, list);
        list.add(A.val);
        kthsmallestUtil(A.right, B, list);
    }
}
