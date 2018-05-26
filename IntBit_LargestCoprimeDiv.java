public class Solution {
    
    public int gcd(int x, int y){
        if(y == 0) return x;
        if(x < y){
            return gcd(y,x);
        }
        return gcd(y, x%y);
    }
    public int cpFact(int A, int B) {
        while(gcd(A,B) != 1){
            A = A/gcd(A,B);
        }
        return A;
    }
}
