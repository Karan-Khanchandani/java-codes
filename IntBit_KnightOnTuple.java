public class Solution {
    
    static class Tuple{
        int x,  y,  dist;
        public Tuple(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.dist = d;
        }
    }
    public int knight(int A, int B, int C, int D, int E, int F) {
        int row = A;
        int col = B;
        Queue<Tuple> q = new LinkedList<>();
        int ans = Integer.MAX_VALUE;
        

        q.add(new Tuple(C,D, 0));
        boolean[][] visited = new boolean[A+1][B+1];
        
        for(int i = 0 ; i < A+1; i++)
            for(int j = 0; j < B+1; j++) visited[i][j] = false;
    
        visited[C][D] = true;
        
        int dr[] = {-2,-2,-1,-1,1,1,2,2};
        int dc[] = {-1,1,-2,2,-2,2,-1,1};
        
        while(!q.isEmpty()){
            Tuple top = q.poll();
           
            if(top.x == E && top.y == F){
                ans = Math.min(ans, top.dist);
            }
            int x1 = top.x;
            int y1 = top.y;
            for(int i = 0; i < 8; i++){
                int dx = x1 + dr[i];
                int dy = y1 + dc[i];
                if(dx > 0 && dx <= A && dy > 0 && dy <= B && !visited[dx][dy]){
                    q.add(new Tuple(dx, dy, top.dist + 1));
                     //System.out.println(dx + " " + dy + " "+ top.get(2) + 1);
                    visited[dx][dy] = true;
                }
            }
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
