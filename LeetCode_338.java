class Solution {
    public int[] countBits(int num) {
        int ans[] = new int[num+1];
        if(num == 0){
            ans[0] = 0;
            return ans;
        }
        
        ans[0] = 0;
        ans[1] = 1;
        
        for(int i = 2; i <= num ; i++){
            int currNum = i;
            //largest power of 2 less than i
            //mask the leftmost 1
            int leftMostBit =  (int)Math.floor((double)Math.log(i)/Math.log(2));
            currNum &= ~(1 << leftMostBit);
            ans[i] = 1 + ans[currNum];
        }
        
        return ans;
        
    }
}
