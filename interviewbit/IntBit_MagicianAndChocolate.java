package interviewbit;

import java.math.BigInteger;
public class Solution {
    
    public static int mod = 1000000007;
    
    public int nchoc(int A, ArrayList<Integer> B) {
        PriorityQueue<Integer> q = new PriorityQueue<>(B.size(), Collections.reverseOrder());
        for(int i = 0; i < B.size(); i++){
            q.add(B.get(i));
        }
        
        BigInteger ans = BigInteger.ZERO;
        for(int i = 0; i < A; i++){
            int top = q.poll();
            ans = ans.add(new BigInteger(String.valueOf(top)));
            q.add(top/2);
        }
        ans = ans.mod(new BigInteger(String.valueOf(mod)));
        return ans.intValue();
    }
}
