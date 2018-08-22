class Solution {
    public int uniqueLetterString(String S) {
        int[][] index = new int[26][2];
        for(int i = 0; i < 26; i++) Arrays.fill(index[i] , -1);
        int res = 0;
        int MOD = (int)Math.pow(10, 9) + 7;
        int n = S.length();
        for(int i = 0; i < n; i++){
            int c = S.charAt(i) - 'A';
            res = (res + ((index[c][1] - index[c][0])*(i - index[c][1]))%MOD)%MOD;
            index[c] = new int[]{index[c][1], i};
        }
        
        for(int c = 0; c < 26; c++){
            res = (res + ((index[c][1] - index[c][0])*(n - index[c][1]))%MOD)%MOD;
        }
        
        return res;
    }
}
