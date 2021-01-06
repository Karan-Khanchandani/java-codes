package interviewbit;

public class Solution {
    public int numDecodings(String A) {
        int n = A.length();
        if (n == 0) return 0;

        int[] memo = new int[n + 1];
        memo[n] = 1;
        memo[n - 1] = A.charAt(n - 1) != '0' ? 1 : 0;

        for (int i = n - 2; i >= 0; i--)
            if (A.charAt(i) == '0') continue;
            else memo[i] = (Integer.parseInt(A.substring(i, i + 2)) <= 26) ? memo[i + 1] + memo[i + 2] : memo[i + 1];

        return memo[0];
    }
}
