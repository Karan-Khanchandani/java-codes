package interviewbit;

public class Solution {

    public void combine(long[][] comb) {
        int n = comb.length, mod = 1000000007;
        comb[0][0] = 1;
        for (int i = 1; i < n; i++) {
            comb[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                comb[i][j] = comb[i - 1][j];
                comb[i][j] += comb[i - 1][j - 1];
                comb[i][j] %= mod;
            }
        }
    }

    public int cntPermBST(int A, int B) {
        int mod = 1000000007;
        long[][] comb = new long[A + 1][A + 1];
        long[][] dp = new long[A + 1][B + 1];
        combine(comb);
        dp[0][0] = dp[1][0] = 1;
        for (int i = 2; i <= A; i++) {
            for (int j = 1; j <= B; j++) {
                for (int k = 1; k <= i; k++) {
                    int x = k - 1, y = i - x - 1;

                    long sum1 = 0, sum2 = 0, ret1 = 0;

                    for (int l = 0; l <= j - 2; l++) {

                        sum1 = (sum1 + dp[x][l]) % mod;

                        sum2 = (sum2 + dp[y][l]) % mod;
                    }

                    ret1 = (sum1 * dp[y][j - 1]) % mod;

                    ret1 += (sum2 * dp[x][j - 1]) % mod;

                    ret1 += (dp[x][j - 1] * dp[y][j - 1]) % mod;

                    ret1 = (ret1 * comb[x + y][y]) % mod;

                    dp[i][j] = (dp[i][j] + ret1) % mod;
                }
            }
        }
        return (int) dp[A][B];
    }
}
