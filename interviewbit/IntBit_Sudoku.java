package interviewbit;

public class Solution {
    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        if (a == null || a.size() == 0)
            return;
        solve(a);
    }

    public boolean solve(ArrayList<ArrayList<Character>> board) {
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.get(0).size(); j++) {
                if (board.get(i).get(j) == '.') {
                    for (char c = '1'; c <= '9'; c++) {//trial. Try 1 through 9
                        if (isValid(board, i, j, c)) {
                            //board[i][j] = c; //Put c for this cell
                            board.get(i).set(j, c);
                            if (solve(board))
                                return true; //If it's the solution return true
                            else
                                board.get(i).set(j, '.'); //Otherwise go back
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(ArrayList<ArrayList<Character>> board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board.get(i).get(col) != '.' && board.get(i).get(col) == c) return false; //check row
            if (board.get(row).get(i) != '.' && board.get(row).get(i) == c) return false; //check column
            if (board.get(3 * (row / 3) + i / 3).get(3 * (col / 3) + i % 3) != '.' &&
                    board.get(3 * (row / 3) + i / 3).get(3 * (col / 3) + i % 3) == c) return false; //check 3*3 block
        }
        return true;
    }
}
