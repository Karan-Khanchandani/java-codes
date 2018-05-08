//need to improve
import java.math.BigInteger;
class Solution {
    public int numTrees(int n) {
        BigInteger den = BigInteger.ONE;
        for(int i = 1; i <= n; i++){
            den = den.multiply(new BigInteger(String.valueOf(i)));
        }
        
        BigInteger num = BigInteger.ONE;
        for(int i = 2*n,j = 0; j < n; j++, i--){
            num = num.multiply(new BigInteger(String.valueOf(i)));
        }
        
        BigInteger ans = num.divide(den);
        ans = ans.divide(new BigInteger(String.valueOf(n+1)));
        return ans.intValue();
    }
}
