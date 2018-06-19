public class Solution {
    public String longestPalindrome(String A) {
        if(A == null || A.length() == 0)return A;
        
        int len = 0, finalL  = 0, finalR = A.length() - 1;
        for(int i = 0; i < A.length(); i++){
            //odd length
            int l = i, r = i;
            while(l >= 0 && r < A.length() && A.charAt(l) == A.charAt(r)){
                l--;r++;
            }
            int temp = r - l - 1;
            if(temp > len){
                len = temp;
                finalL = l+1;
                finalR = r-1;
            }
            //even length
            l = i; r = i+1;
            while(l >= 0 && r < A.length() && A.charAt(l) == A.charAt(r)){
                l--;r++;
            }
            temp = r - l - 1;
            if(temp > len){
                len = temp;
                finalL = l+1;
                finalR = r-1;
            }
        }
        
        return A.substring(finalL, finalR+1);
    }
}
