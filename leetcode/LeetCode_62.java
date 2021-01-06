package leetcode;

class LeetCode_62 {
    
    public int bin_coff(int n, int k){
        int[][] C = new int[n+1][k+1];
        int i, j;
 
        // Caculate value of Binomial Coefficient in bottom up manner
        for (i = 0; i <= n; i++)
        {
            for (j = 0; j <= Math.min(i, k); j++)
            {
                // Base Cases
                if (j == 0 || j == i)
                    C[i][j] = 1;

                // Calculate value using previosly stored values
                else
                    C[i][j] = C[i-1][j-1] + C[i-1][j];
            }
        }

        return C[n][k];
    }
    
    public int uniquePaths(int m, int n) {
        return bin_coff(m+n-2,m-1);
    }
}
