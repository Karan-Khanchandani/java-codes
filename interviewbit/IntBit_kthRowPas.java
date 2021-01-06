package interviewbit;

public class Solution {
    public ArrayList<Integer> getRow(int A) {
        int dp[][] = new int[A + 1][A + 1];
        for (int i = 0; i < A + 1; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                }

            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < dp[A].length; i++) {
            res.add(dp[A][i]);
        }
        return res;

    }
}
