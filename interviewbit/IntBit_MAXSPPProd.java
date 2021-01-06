package interviewbit;

import java.math.BigInteger;
public class Solution {
    static class Pair{
        int first, second;
        public Pair(int f, int s){
            first = f;
            second = s;
        }
    }
    static final int MOD = 1000000007;
    public int maxSpecialProduct(ArrayList<Integer> A) {
        if(A.size() <= 2) return 0;
        Stack<Pair> st = new Stack<>();
        int n = A.size();
        int B[] = new int[n];
        int[] C = new int[n];
        st.push(new Pair(1000000004,0));
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && A.get(i) >= st.peek().first){
                st.pop();
            }
            B[i] = st.peek().second;
            st.push(new Pair(A.get(i), i));
        }
        st.clear();
        st.push(new Pair(1000000004,0));
        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && A.get(i) >= st.peek().first){
                st.pop();
            }
            C[i] = st.peek().second;
            st.push(new Pair(A.get(i), i));
        }
        
        BigInteger ans = BigInteger.ZERO;
        for(int i = 0; i < n; i++){
            BigInteger prod = new BigInteger(String.valueOf(B[i])).multiply(new BigInteger(String.valueOf(C[i])));
            if(ans.compareTo(prod) < 0){
                ans = prod;
            }
        }
        ans = ans.mod(new BigInteger(String.valueOf(MOD)));
        return ans.intValue();
    }
}
