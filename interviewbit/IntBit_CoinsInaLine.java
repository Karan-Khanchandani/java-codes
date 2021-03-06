package interviewbit;

public class Solution {
    public int maxcoin(ArrayList<Integer> A) {
        int n = A.size();
        if (n == 0) return 0;
        int gap = 0;
        int[][] dp = new int[n][n];

        for (gap = 0; gap < n; ++gap) {
            for (int i = 0, j = gap; j < n; ++i, ++j) {
                int x = ((i + 2) <= j) ? dp[i + 2][j] : 0;
                int y = ((i + 1) <= (j - 1)) ? dp[i + 1][j - 1] : 0;
                int z = (i <= (j - 2)) ? dp[i][j - 2] : 0;

                dp[i][j] = Math.max(A.get(i) + Math.min(x, y), A.get(j) + Math.min(y, z));
            }
        }

        return dp[0][n - 1];
    }
}
