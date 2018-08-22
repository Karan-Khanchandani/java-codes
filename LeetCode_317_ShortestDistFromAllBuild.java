class Solution {
    public int shortestDistance(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] reachCount = new int[m][n];
        int[][] dist = new int[m][n];
        int houseCount = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) houseCount++;
            }
        }
        
        //logic
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    if(!bfs(grid, reachCount, dist, houseCount, i, j, m, n)){
                        return -1;
                    }
                }
            }
        }
        
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            for(int j = 0;j < n; j++){
                if(grid[i][j] == 0 && reachCount[i][j] == houseCount){
                    min = Math.min(min, dist[i][j]);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    
    public static boolean bfs(int[][] grid, int[][] reachCount, int[][] dist, int houseCount, int x, int y, int m, int n){
        int[][] visited = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        int level = 0;
        int count = 0;
        
        while(!q.isEmpty()){
            
            int size = q.size();
            level++;
            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                for(int k = 0; k < 4; k++){
                    int x1 = curr[0] + dx[k];
                    int y1 = curr[1] + dy[k];
                    if(x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && visited[x1][y1] == 0){
                        if(grid[x1][y1] == 0){
                            dist[x1][y1] += level;
                            visited[x1][y1] = 1;
                            reachCount[x1][y1]++;
                            q.offer(new int[]{x1, y1});
                        }else if (grid[x1][y1] == 1){
                            count++;
                            visited[x1][y1] = 1;
                        }
                    }
                }
            }   
        }
        
        return count == houseCount;
    }
}
