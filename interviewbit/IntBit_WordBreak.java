package interviewbit;

public class Solution {
    public int wordBreak(String A, ArrayList<String> B) {
        boolean[] dp = new boolean[A.length() + 1];
        Set<String> set = new HashSet<>();
        set.addAll(B);
        dp[0] = true;
        for(int i = 1; i <= A.length(); i++){
            for(int j = i-1; j >=0 ; j--){
                dp[i] = dp[j] && set.contains(A.substring(j, i));
                if(dp[i]) break;
            }
        }
        
        return dp[A.length()] ? 1 : 0;
    }
}
