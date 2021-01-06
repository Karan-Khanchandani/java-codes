package interviewbit;

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        int xor = 0;
        int n = A.size();
        for (int i = 0; i < A.size(); i++) {
            xor ^= A.get(i);
        }
        for (int i = 1; i <= n; i++) xor ^= i;

        int set_bit = xor & ~(xor - 1);
        int a = 0, b = 0;
        for (int i = 0; i < A.size(); i++) {
            if ((A.get(i) & set_bit) > 0) {
                a ^= A.get(i);
            } else b ^= A.get(i);
        }

        for (int i = 1; i <= n; i++) {
            if ((i & set_bit) > 0) {
                a ^= i;
            } else b ^= i;
        }
        int rep = 0, miss = 0;
        boolean flag = false;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i).intValue() == a) {
                flag = true;
                break;
            }
        }

        if (flag) {
            rep = a;
            miss = b;
        } else {
            miss = a;
            rep = b;
        }
        return new ArrayList<>(Arrays.asList(rep, miss));
    }
}
