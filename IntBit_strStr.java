public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    static char[] P, T;
    static int n,m;
    static int[] b;
    
    static void kmpProcess(){
        b = new int[m+1];
        b[0] = -1;
        int i = 0, j = -1;
        while(i < m){
            while(j >= 0 && P[i] != P[j]) j = b[j];
            i++;j++;
            b[i] = j;
        }
    }
    static int kmpMatching(){
        kmpProcess();
        int i = 0, j = 0;
        while(i < n){
            while(j >= 0 && T[i] != P[j]) j = b[j];
            i++;j++;
            if(j == m) return i;
        }
        return -1;
    }
    public int strStr(final String A, final String B) {
        P = B.toCharArray();
        T = A.toCharArray();
        n = T.length;
        m = P.length;
        int idx = kmpMatching();
        if(idx  == -1)return idx;
        return (idx - m);
    }
}
