public class Solution {
    
    public static int n;
    public static boolean isPrime[];
    public static boolean isActuallyPrime(int num){
        for(int i = 2; i<= Math.sqrt(num); i++){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }
    public static void calc(){
        isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(isPrime[i] && isActuallyPrime(i)){
                isPrime[i] = true;
                int j = 2;
                while(i*j <= n){
                    isPrime[i*j] = false;
                    j++;
                }
            }
        }
    }
    
    public ArrayList<Integer> primesum(int A) {
        n = A;
        calc();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i = 0; i <= A; i++){
            
            if(isPrime[i] && isPrime[A-i]){
                ans.add(i);
                ans.add(A - i);
                break;
            }
        }
        return ans;
    }
}
