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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(A == null) return res;
        pathSumUtil(res, new ArrayList<>(), A,0, B);
        return res;
    }
    
    public void pathSumUtil(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, TreeNode A,int currSum, int B){
        if(A == null) return;
        if(A.left == null && A.right == null && (currSum + A.val == B)){
            ArrayList<Integer> ans = new ArrayList<>(temp);
            ans.add(A.val);
            res.add(ans);
        }
        temp.add(A.val);
        pathSumUtil(res, temp, A.left, currSum + A.val, B);
        pathSumUtil(res, temp, A.right, currSum + A.val, B);
        temp.remove(temp.size() - 1);
    }
}
