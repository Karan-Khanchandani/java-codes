public class Solution {
    public int mice(ArrayList<Integer> A, ArrayList<Integer> B) {
        if(A.size() == 0 || B.size() == 0) return 0;
        if(A.size() != B.size()) return 0;
        
        Collections.sort(A);
        Collections.sort(B);
        
        int maxDiff = 0;
        for(int i = 0; i < A.size(); i++){
            maxDiff = Math.max(maxDiff, Math.abs(A.get(i) - B.get(i)));
        }
        return maxDiff;
    }
}
