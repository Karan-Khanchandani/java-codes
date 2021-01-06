package interviewbit;

public class Solution {
    public int isInterleave(String A, String B, String C) {
        char [] c1 = A.toCharArray(), c2 = B.toCharArray(), c3 = C.toCharArray();
        int m = A.length(), n = B.length();
        if(m + n != C.length()) return 0;
        return (dfs(c1, c2, c3, 0, 0, 0, new boolean[m + 1][n + 1])) ? 1 : 0;
    }
    
    public boolean dfs(char[] c1, char[] c2, char[] c3, int i, int j, int k, boolean[][] invalid) {
        if(invalid[i][j]) return false;
        if(k == c3.length) return true;
        boolean valid = 
            i < c1.length && c1[i] == c3[k] && dfs(c1, c2, c3, i + 1, j, k + 1, invalid) || 
            j < c2.length && c2[j] == c3[k] && dfs(c1, c2, c3, i, j + 1, k + 1, invalid);
        if(!valid) invalid[i][j] = true;
        return valid;
    }
}
