public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int isValidSudoku(final List<String> A) {
        //check rows
        int[][] rows, cols, cube;
        rows = new int[9][9];
        cols = new int[9][9];
        cube = new int[9][9];
        for(int i = 0; i < A.size(); i++){
            for(int j = 0; j < A.size(); j++){
                if(A.get(i).charAt(j) != '.'){
                    int num = A.get(i).charAt(j) - '0' - 1;
                    int k = (i/3)*3 + j/3;
                    if(rows[i][num] == 1 || cols[j][num] == 1 || cube[k][num] == 1)
                    return 0;
                    rows[i][num] = cols[j][num] = cube[k][num] = 1; 
                }
            }
        }
        return 1;
    }
}
