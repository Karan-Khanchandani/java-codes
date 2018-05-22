class Solution {
    public int dominantIndex(int[] nums) {
        if(nums.length == 0 || nums == null){
            return -1;
        }
        
        int max = 0, index = -1;
        boolean yes = true;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max){
                if(nums[i] >= 2*max){
                    yes = true;
                    max = nums[i];
                    index = i;
                }else{
                    yes = false;
                    max = nums[i];
                } 
            }else{
                if(nums[i]*2 > max){
                    yes = false;
                }
            }
        }
        if(yes){
            return index;
        }
        return -1;
    }
}
