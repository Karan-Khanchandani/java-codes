import java.util.ArrayList;
import java.util.List;

/*
Problem Description:
Generate all solutions of n queen problem
*/

public class Problem_16_2 {

    public static List<List<Integer>> solveNQueen(int n) {
        List<List<Integer>> solutions = new ArrayList<>();
        solveNQueenHelper(0, n, new ArrayList<Integer>(), solutions);
        return solutions;
    }

    public static void solveNQueenHelper(int rowID, int n, List<Integer> cols, List<List<Integer>> solutions) {
        if(rowID == n){
            solutions.add(new ArrayList<>(cols));
        }else{
            for (int i = 0; i < n; i++) {
                cols.add(i);
                if (isValidPlacement(cols)) {
                    solveNQueenHelper(rowID+1, n, cols, solutions);
                }
                cols.remove(cols.size() - 1);
            }
        }      

    }

    public static boolean isValidPlacement(List<Integer> cols){
        int rowID = cols.size() -1 ;
        for(int i = 0; i < rowID; i++){
            int diff = Math.abs(cols.get(i) - cols.get(rowID));
            if(diff == 0 || diff == rowID - i){
                return false;
            }
        }
        return true;
    }

    public static void printList(List<Integer> list){
        System.out.print("[ ");
        for(Integer i : list){
            System.out.print(i + " ");
        }
        System.out.print("]");
        System.out.println();
    }

    public static void main(String[] args) {
        List<List<Integer>> solutions = solveNQueen(8);

        for (int i = 0; i < solutions.size(); i++) {
            printList(solutions.get(i));
        }
    }
}