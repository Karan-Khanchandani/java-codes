package leetcode;

class Solution {
    
    public boolean dfs(char[][] board, int x, int y, int idx, String word){
        if(idx == word.length()) return true;
        if(x < 0 || x >= board.length || y < 0 || y >= board[x].length || board[x][y] != word.charAt(idx)) return false;
        char temp = board[x][y];
        board[x][y]  = '#';
        boolean found =  (temp == word.charAt(idx)) && (dfs(board, x+1, y, idx+1, word) || dfs(board, x, y+1, idx+1, word) || dfs(board, x-1, y, idx+1, word)|| dfs(board, x, y-1, idx+1, word));
        
        board[x][y] = temp;
        return found;
        
    }
    public boolean exist(char[][] board, String word) {
        boolean found = false;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board, i, j, 0, word)) return true;
                }
            }
        }
        return false;
    }
}
