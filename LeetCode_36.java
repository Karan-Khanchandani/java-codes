class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            if(!isValid(board, i, i, 0, board[i].length - 1)){
                return false;
            }
        }
        
        for(int j = 0; j < 9; j++){
            if(!isValid(board, 0, board.length - 1, j, j)){
                return false;
            }
        }
        
        for(int k = 0; k < 9; k++){
            if(!isValid(board, 3*(k/3), 3*(k/3) + 2, 3*(k%3), 3*(k%3) + 2)){
                return false;
            }
        }
        return true;
    }
    
    
    public boolean isValid(char[][] board, int rowStart, int rowEnd, int colStart, int colEnd){
        int nums[] = new int[board.length];
        for(int i = rowStart; i <= rowEnd; i++){
            for(int j = colStart; j <= colEnd; j++){
                if(board[i][j] != '.'){
                   nums[Character.getNumericValue(board[i][j]) - 1]++;
                if(nums[Character.getNumericValue(board[i][j]) - 1] > 1){
                    return false;
                } 
                }
                
            }
        }
        
        return true;
    }
}
