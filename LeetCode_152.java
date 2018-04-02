class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        
        for(int i = 1, imax = res, imin = res; i < nums.length; i++){
            if(nums[i] < 0){
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);
            
            res = Math.max(res, imax);
        }
        
        return res;
    }
}
