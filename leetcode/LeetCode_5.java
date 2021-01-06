package leetcode;

class LeetCode_5 {
    private int start, maxLen;
    public String longestPalindrome(String s) {
        if(s.length() < 2){
            return s;
        }
        
         for(int i = 0; i < s.length() - 1; i++){
            //odd length
             find_palindrome(s, i, i);
             //even length
             find_palindrome(s, i, i + 1);
         }
        
        return s.substring(start, start + maxLen);
    }
    
    public void find_palindrome(String s, int low, int high){
        int j = low, k = high;
        
        while(j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)){
            j--;
            k++;
        }
        
        if(maxLen < k - j  - 1){
            maxLen = k - j - 1;
            start = j + 1;
        }
    }
                                                
}
