public class Solution {
    public int minPathSum(int[][] A) {
        if(A == null || A.length == 0) return 0;
        int n = A.length;
        int m = A[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int top = (i == 0)? 0: A[i-1][j];
                int left = (j == 0)? 0 : A[i][j-1];
                if(i == 0){
                    A[i][j] += left;
                }else if(j == 0){
                    A[i][j] += top;
                }else{
                    A[i][j] += Math.min(top, left);
                }
            }
        }
        return A[n-1][m-1];
    }
}
