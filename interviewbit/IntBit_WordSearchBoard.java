package interviewbit;

public class Solution {
    public int exist(ArrayList<String> A, String B) {
        
        //base cases
        int n = A.size();
        if(n == 0) return 0;
        int m = A.get(0).length();
        if(m == 0) return 0;
        if(B.equals("")) return 1;
        
        char[][] board = new char[n][m];
        for(int i = 0; i < A.size(); i++){
            board[i] = A.get(i).toCharArray();
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == B.charAt(0)){
                    if(dfs(board,i,j,n,m,0,B)) return 1;
                }
            }
        }
        return 0;
    }
    
    public boolean dfs(char[][] board, int x, int y, int n, int m,int count, String B){
        if(x > n-1 || x < 0 || y > m-1 || y < 0) return false;
        if(count == B.length()){
            return true;
        }
        if(board[x][y] == B.charAt(count)){
            return dfs(board, x+1,y,n,m,count+1,B) || dfs(board, x-1,y,n,m,count+1,B) ||
            dfs(board, x,y+1,n,m,count+1,B) || dfs(board, x,y-1,n,m,count+1,B);
        }
        return false;
    }
}
