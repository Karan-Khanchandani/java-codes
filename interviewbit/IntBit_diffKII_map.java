package interviewbit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntBit_diffKII_map {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int diffPossible(final List<Integer> A, int B) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < A.size(); i++){
            int num = A.get(i);
            if(!map.containsKey(num)){
                map.put(num, i);
            }
            Integer left = map.get(num + B);
            Integer right = map.get(num  -B);
            if(left != null && left != i) return 1;
            if(right != null && right != i) return 1;
        }
        return 0;
    }
}
