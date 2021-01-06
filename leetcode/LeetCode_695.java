package leetcode;

class Solution {
    
    public void dfs(int[][] grid, int x, int y, int color, int[] temp){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[x].length) return;
        if(grid[x][y] == 1){
            grid[x][y] = color;
            temp[0]++;
            dfs(grid, x+1,y,color,temp);
            dfs(grid, x-1,y,color,temp);
            dfs(grid, x,y-1,color,temp);
            dfs(grid, x,y+1,color,temp);
            
        }    
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0, color = 1;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    int[] temp = new int[1];
                    dfs(grid, i, j, ++color, temp);
                    maxArea = Math.max(maxArea, temp[0]);
                    temp[0] = 0;
                }
            }
        }
        return maxArea;
    }
}
