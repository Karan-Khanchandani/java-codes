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
 import java.math.BigInteger;
public class Solution {
    public int sumNumbers(TreeNode A) {
        long res = sumNumbersUtil(A, 0);
        return (int)(res);
    }
    
    public long sumNumbersUtil(TreeNode A, long ans){
        if(A == null) return 0;
        long temp = (ans%1003*10 + A.val)%1003;
        if(A.left == null && A.right == null) return temp%1003;
        return (sumNumbersUtil(A.left, temp)%1003 + sumNumbersUtil(A.right, temp)%1003)%1003;
    }
}
