public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxProfit(final int[] A) {
        if(A == null || A.length == 0)return 0;
        
        int maxProfit = 0;
        int mini = A[0];
        for(int i = 1; i < A.length; i++){
            maxProfit = Math.max(maxProfit, A[i] - mini);
            mini = Math.min(mini, A[i]);
        }
        return maxProfit;
    }
}
