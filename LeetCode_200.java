class Solution {
    public int numIslands(char[][] grid) {
        int numIslands[] = new int[1];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    numIslands[0]++;
                   dfs(grid, i, j, numIslands);
                    grid[i][j] = '1';
                }
                if(grid[i][j] == '#'){
                    grid[i][j] = '1';
                }
            }
        }
        
        return numIslands[0];
    }
    public static final int DIR[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public void dfs(char[][] grid, int row, int col, int[] numIslands){
        grid[row][col] = '#';
        
        for(int i = 0; i < DIR.length; i++){
            int x = DIR[i][0];
            int y = DIR[i][1];
            if(row + x >= 0 && row + x < grid.length && col + y < grid[row + x].length && col + y >=0 && grid[row + x][col+ y] == '1'){
                dfs(grid, row + x,col + y , numIslands);
            }
        }
    }
}
