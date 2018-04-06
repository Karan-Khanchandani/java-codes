class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        
        int dp[][] = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(i == 0){
                    dp[i][j] = grid[i][j] + ((j == 0) ? 0 : dp[i][j-1]);
                }else if(j == 0){
                    dp[i][j] = grid[i][j] + ((i == 0) ? 0 : dp[i-1][j]);
                }else{
                    int left = dp[i][j - 1];
                    int top = dp[i - 1][j];     
                    dp[i][j] = grid[i][j] + Math.min(left, top); 
                }
                
                
               
            }
        }
        
        return dp[grid.length - 1][grid[0].length - 1];
    }
}
