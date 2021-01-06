package leetcode;

class Solution {
    static char[] T, P;
    static int[] b;
    static int n,m;
    
    static void kmpProcess(){
        b = new int[m+1];
        b[0] = -1;
        int i = 0, j = -1;
        while(i < m){
            while(j >= 0  && P[i] != P[j])j = b[j];
            i++;j++;
            b[i] = j;
        }
        
    }
    
    static int kmpMatching(){
        kmpProcess();
        int i = 0, j = 0;
        while(i < n){
            while(j >= 0 && T[i] != P[j])j = b[j];
            i++;j++;
            
            if(j == m){
                j = -1;
            }
            
        }
        return j;
    }
    
    public String shortestPalindrome(String s) {
        String t = new StringBuilder(s).reverse().toString();
        T = t.toCharArray();
        String p= s;
        P = p.toCharArray();
        n = m =  T.length;
        int tail = kmpMatching();
        if(tail == -1){
            return s;
        }else{
            return t + p.substring(tail);
        }
    }
} 
