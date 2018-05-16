public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maximumGap(final List<Integer> A) {
        
        int[] lMin = new int[A.size()];
        int[] rMax = new int[A.size()];
        for(int i = 0; i < lMin.length; i++){
            lMin[i] = (i == 0)? A.get(i) : Math.min(lMin[i-1], A.get(i));
        }
        rMax[rMax.length -1] = A.get(A.size() - 1);
        
        for(int i = rMax.length - 2; i >= 0; i--){
            rMax[i] = Math.max(rMax[i+1], A.get(i));
        }
        
        int i = 0, j = 0;
        int maxDiff = -1;
        while(i < A.size() && j < A.size()){
            if(lMin[i] <= rMax[j]){
                maxDiff = Math.max(maxDiff, j -i);
                j++;
            }else{
                i++;
            }
        }
        
        return maxDiff;
    }
}
