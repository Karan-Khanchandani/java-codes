package interviewbit;

public class Solution {
    
    public static boolean isActuallyPrime(int num){
        int up = (int)Math.sqrt(num);
        for(int i = 2; i <= up; i++){
            if(i < num && num%i == 0){
                return false;
            }
        }
        return true;
    }
    public ArrayList<Integer> sieve(int A) {
        boolean[] isPrime = new boolean[A+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i = 2; i < isPrime.length ; i++){
            if(isPrime[i]){
                if(isActuallyPrime(i)){
                    int j = 2;
                    while(i*j <= A){
                        isPrime[i*j] = false;
                        j++;
                    }
                }else{
                    isPrime[i] = false;
                }
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < isPrime.length; i++){
            if(isPrime[i]){
                ans.add(i);
            }
        }
        return ans;
    }
}
