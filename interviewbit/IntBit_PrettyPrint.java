package interviewbit;

public class Solution {
    public ArrayList<ArrayList<Integer>> prettyPrint(int A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(A == 0){
            return res;
        }
        
        for(int i = 0; i < 2*A-1; i++){
            res.add(new ArrayList<Integer>());
            for(int j = 0; j < 2*A-1; j++){
                res.get(i).add(0);
            }
        }
        
        int rowStart = 0, rowEnd = res.size() - 1, colStart = 0, colEnd = res.get(0).size() - 1;
        int num = A;
        while(rowStart <= rowEnd && colStart <= colEnd){
                for(int i = colStart; i <= colEnd; i++){
                res.get(rowStart).set(i, num);
                }
                rowStart++;
                for(int i = rowStart; i <= rowEnd; i++){   
                res.get(i).set(colEnd, num);
                }
                colEnd--;
                for(int i = colEnd; i >= colStart; i--){         
                res.get(rowEnd).set(i, num);
                }
                rowEnd--;
                 for(int i = rowEnd; i >= rowStart; i--){ 
                res.get(i).set(colStart, num);
                }
                colStart++;
                num--;    
        }
        return res;
    }
}
