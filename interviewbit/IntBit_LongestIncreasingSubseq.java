package interviewbit;

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int lis(final int[] A) {
        if(A.length == 0) return 0;
        ArrayList<Integer> sortedSeq = new ArrayList<>();
        for(int i = 0; i < A.length; i++){
            int currElem = A[i];
            int idx = Collections.binarySearch(sortedSeq, currElem);
            if(idx < 0){
                idx = -(idx + 1);
            }
            if(idx >= sortedSeq.size()){
                sortedSeq.add(currElem);
            }else{
                sortedSeq.set(idx, currElem);
            }
        }
        return sortedSeq.size();
    }
}
