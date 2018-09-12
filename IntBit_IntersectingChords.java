public class Solution {
    public int chordCnt(int A) {
        int n = 2*A;
        long dp[] = new long[n+1];
        dp[0] = 1;
        dp[2] = 1;
        int MOD = (int)(Math.pow(10,9)) + 7;
        for(int i = 4; i <= n; i += 2){
            for(int j = 0; j < i-1; j+=2){
                long temp = dp[j]*dp[i-j-2];
                dp[i] = (dp[i] +  temp)%MOD;
            }
        }
        
        return (int)(dp[n]%MOD);
    }
}
