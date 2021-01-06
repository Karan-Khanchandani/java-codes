package leetcode;

class LeetCode_53 {
    public int maxSubArray(int[] nums) {
        int max_so_far = nums[0], curr_max = nums[0];
        int res = nums[0];
        for(int i = 1; i < nums.length ; i++){
            if(max_so_far > 0){
                curr_max = max_so_far + nums[i];
            }else{
                curr_max = nums[i];
            }
            
            res = Math.max(res, curr_max);
            max_so_far = curr_max;
        } 
        
        return res;
    }
    
}
