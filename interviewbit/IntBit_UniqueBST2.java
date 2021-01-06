package interviewbit;

import java.math.BigInteger;
public class Solution {
    public int numTrees(int A) {
        return catalan(A);
    }
    
    public int catalan(int num){
        BigInteger nume = BigInteger.ONE;
        BigInteger dene = BigInteger.ONE;
        for(int i = 2*num; i > num; i--){
            nume = nume.multiply(new BigInteger(String.valueOf(i)));
        }
        for(int i = 1; i <= num; i++){
            dene = dene.multiply(new BigInteger(String.valueOf(i)));
        }
        
        BigInteger ans = nume.divide(dene);
        ans = ans.divide(new BigInteger(String.valueOf(num + 1)));
        return ans.intValue();
    }
}
