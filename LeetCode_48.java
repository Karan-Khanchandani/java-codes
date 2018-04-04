class Solution {
    public void rotate(int[][] matrix) {
       
        for(int x = 0; x < matrix.length/2 ; x++){
            for(int y = x; y < matrix.length - x - 1; y++){
                
                int temp = matrix[x][y];
                
                // left to top
                matrix[x][y] = matrix[matrix.length - y - 1][x];
                //bottom to left
                matrix[matrix.length - y - 1][x] = matrix[matrix.length - x - 1][matrix.length - y - 1];
                //right to bottom
                matrix[matrix.length - x - 1][matrix.length - y - 1] = matrix[y][matrix.length - x - 1];
                
                matrix[y][matrix.length - x - 1] = temp;
                
            }
        }
       
    }
} 
