package interviewbit;

public class Solution {
    public int black(ArrayList<String> A) {
        if(A.size() == 0) return 0;
        int count = 0;
        char[][] board = new char[A.size()][A.get(0).length()];
        for(int i = 0; i < A.size(); i++){
            board[i] = A.get(i).toCharArray();
        }
        int n = board.length;
        int m = board[0].length;
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'X'){
                    dfs(board, i,j,n,m);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public void dfs(char[][] board, int i, int j, int n, int m){
        board[i][j] = 'O';
        if(i + 1 < n && board[i+1][j] == 'X') dfs(board,i+1,j,n,m);
        if(i -1 >=0 && board[i-1][j] == 'X') dfs(board,i-1,j,n,m);
        if(j+1 < m && board[i][j+1] == 'X') dfs(board, i, j+1, n, m);
        if(j-1 >=0 && board[i][j-1] == 'X') dfs(board,i,j-1,n,m);
    }
}
