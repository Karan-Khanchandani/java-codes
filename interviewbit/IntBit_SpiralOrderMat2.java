package interviewbit;

public class Solution {
    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        int k = 1, dir = 0;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i = 0; i < A; i++){
            res.add(new ArrayList<>());
            for(int j =0 ; j < A;j++){
                res.get(i).add(0);
            }
        }
        int startRow = 0, endRow = A-1, startCol = 0, endCol = A-1;
        while(startRow <= startCol && startCol <= endCol){
            for(int i = startCol; i <= endCol; i++){
                res.get(startRow).set(i, k++);
            }
            startRow++;
            for(int i = startRow; i <= endRow; i++){
                res.get(i).set(endCol, k++);
               
            }
             endCol--;
            for(int i = endCol; i >= startCol; i--){
                res.get(endRow).set(i, k++);
               
            }
             endRow--;
            for(int i = endRow; i >= startRow; i--){
                res.get(i).set(startCol, k++);
                
            }
            startCol++;
            
        }
        return res;
    }
}
