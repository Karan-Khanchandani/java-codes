class Solution {
    public int pivotIndex(int[] nums) {
        
        if(nums.length == 0 || nums == null){
            return -1;
        }
        
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        leftSum[0] = 0;
        rightSum[nums.length - 1] = 0;
        
        for(int i = 1; i < nums.length; i++){
            leftSum[i] = nums[i-1] + leftSum[i-1];
        }
        
        for(int i = nums.length - 2; i >=  0; i--){
            rightSum[i] = nums[i+1] + rightSum[i+1];
        }
        
        for(int i = 0; i < nums.length; i++){
            if(leftSum[i] == rightSum[i]){
                return i;
            }
        }
        
        return -1;
    }
}
