package interviewbit;

import java.math.BigInteger;

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public String largestNumber(final List<Integer> A) {
        Collections.sort(A, new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                String a = String.valueOf(x);
                String b = String.valueOf(y);
                String cc1 = a + b;
                String cc2 = b + a;
                if (cc1.compareTo(cc2) > 0) return -1;
                else if (cc1.compareTo(cc2) < 0) return 1;
                return 0;

            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A.size(); i++) {
            sb.append(A.get(i));
        }
        return new BigInteger(sb.toString()).toString();
    }
}
