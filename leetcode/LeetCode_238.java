package leetcode;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftNum = new int[nums.length];
        int[] rightNum = new int[nums.length];
        leftNum[0] = 1;
        for(int i = 1; i < leftNum.length; i++){
            leftNum[i] = nums[i-1]*leftNum[i-1];
        }
        
        rightNum[rightNum.length - 1] = 1;
        for(int i = rightNum.length - 2; i >= 0; i--){
            rightNum[i] = nums[i+1]*rightNum[i+1];
        }
        
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            ans[i] = leftNum[i]*rightNum[i];
        }
        
        return ans;
        
    }
}
