import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Problem Description:
Check if partial sudoku is valid
*/

public class Problem_6_16 {
    public static boolean isValidSudoku(List<List<Integer>> partialSudoku){

        //check if rows have duplicate
        for(int i = 0; i < partialSudoku.size(); i++){
            if(hasDuplicate(partialSudoku, i, i+1, 0, partialSudoku.size())){
                return false;
            }
        }

         //check if cols have duplicate
         for(int i = 0; i < partialSudoku.size(); i++){
            if(hasDuplicate(partialSudoku, 0, partialSudoku.size(),i ,i+1 )){
                return false;
            }
        }

        int regionSize = (int)Math.sqrt(partialSudoku.size());
        for(int i = 0; i < regionSize; i++){
            for(int j = 0; j < regionSize; j++){
                if(hasDuplicate(partialSudoku, i*regionSize, (i+1)*regionSize, j*regionSize, (j+1)*regionSize)){
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean hasDuplicate(List<List<Integer>> partialSudoku, int startRow, int endRow, int startCol,
            int endCol) {
        List<Boolean> isPresent = new ArrayList<>(Collections.nCopies(partialSudoku.size() + 1, false));

        for (int i = startRow; i < endRow; i++) {
            for (int j = startCol; j < endCol; j++) {
                if (partialSudoku.get(i).get(j) != 0 && isPresent.get(partialSudoku.get(i).get(j))) {
                    return true;
                }
                isPresent.set(partialSudoku.get(i).get(j), true);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> partialSudoku = new ArrayList<>();
        partialSudoku.add(new ArrayList<>(Arrays.asList( 5, 3, 0, 0, 7, 0, 0, 0, 0)));
        partialSudoku.add(new ArrayList<>(Arrays.asList( 6, 0, 0, 1, 9, 5, 0, 0, 0)));
        partialSudoku.add(new ArrayList<>(Arrays.asList( 0, 9, 8, 0, 0, 0, 0, 6, 0)));
        partialSudoku.add(new ArrayList<>(Arrays.asList( 8, 0, 0, 0, 6, 0, 0, 0, 3)));
        partialSudoku.add(new ArrayList<>(Arrays.asList( 4, 0, 0, 8, 0, 3, 0, 0, 1)));
        partialSudoku.add(new ArrayList<>(Arrays.asList( 7, 0, 0, 0, 2, 0, 0, 0, 6)));
        partialSudoku.add(new ArrayList<>(Arrays.asList( 0, 6, 0, 0, 0, 0, 2, 8, 0)));
        partialSudoku.add(new ArrayList<>(Arrays.asList( 0, 0, 0, 4, 1, 9, 0, 0, 5)));
        partialSudoku.add(new ArrayList<>(Arrays.asList( 0, 0, 0, 0, 8, 0, 0, 7, 9)));


        System.out.println(isValidSudoku(partialSudoku));
        
    }
}