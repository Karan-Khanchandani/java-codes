package interviewbit;

import java.util.List;

public class IntBit_Array3Pointers {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        
        int diff = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int i, j, k;
        for(i = 0, j = 0, k = 0; i < A.size() && j < B.size() && k < C.size();){
            min = Math.min(A.get(i), Math.min(B.get(j), C.get(k)));
            max = Math.max(A.get(i), Math.max(B.get(j), C.get(k)));
            diff = Math.min(diff, max - min);
            if(diff == 0)
                break;
            if(A.get(i) == min)
                i++;
            else if(B.get(j) == min)
                j++;
            else
                k++;
        }
        return diff;
    }
}
