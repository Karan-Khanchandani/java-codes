public class Solution {
    public void solve(ArrayList<ArrayList<Character>> a) {
        int i, j;
        int row = a.size();
        if(row == 0) return;
        int col = a.get(0).size();
        
        for(i = 0; i < row; i++){
            check(a, i , 0, row , col);
            if(col > 1) check(a, i, col-1, row, col);
        }
        
        for(j = 1; j+1 < col; j++){
            check(a, 0, j, row, col);
            if(row > 1) check(a, row-1, j, row, col);
        }
        
        for( i = 0; i < row; i++){
            for( j = 0; j < col; j++){
                if(a.get(i).get(j) == 'O'){
                    a.get(i).set(j, 'X');
                }
            }
        }
        
        for( i = 0; i < row; i++){
            for( j = 0; j < col; j++){
                if(a.get(i).get(j) == '1'){
                    a.get(i).set(j, 'O');
                }
            }
        }
    }
    
    public void check(ArrayList<ArrayList<Character>> a, int i , int j , int row, int col){
        if(a.get(i).get(j) == 'O'){
            a.get(i).set(j, '1');
            if(i > 1) check (a, i-1,j, row, col);
            if(j > 1) check(a, i, j-1, row, col);
            if(i+1 < row) check(a, i+1,j, row, col);
            if(j+1 < col) check(a, i,j+1, row, col);
        }
    }
}
