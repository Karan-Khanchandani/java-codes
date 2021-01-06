package leetcode;

class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        if(A == null || A[0].length == 0){
            return A;
        }
        int n = A.length;
        for(int i = 0 ; i < A.length; i++){
            for(int j = 0; j < A.length/2; j++){
                int temp = A[i][j];
                A[i][j] = A[i][n-1-j];
                A[i][n-1-j] = temp;
            }
        }
        
        for(int i = 0 ; i < A.length; i++){
            for(int j = 0; j < A.length; j++){
                if(A[i][j] == 0){
                    A[i][j] =1;
                }else{
                    A[i][j] = 0;
                }
            }
        }
        
        return A;
    }
}
