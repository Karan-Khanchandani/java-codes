class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        if(nums.length == 0){
            return new int[]{-1,-1};
        }
        
        if(nums.length == 1){
            if(target == nums[0]){
                return new int[]{0, 0};
            }else{
                return new int[]{-1,-1};
            }
        }
        
        
        int left = 0, right = nums.length - 1, result = -1,  leftIdx = Integer.MAX_VALUE;
        while(left + 1 < right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
               // rightIdx = Math.max(mid, rightIdx);
                leftIdx = Math.min(mid, leftIdx);
                right = mid;
            }else if(nums[mid] > target){
                right = mid;
            }else{
                left = mid;
            }
        }
        
        if( nums[right] == target){
            leftIdx = right;
        }
        if(nums[left] == target){
            leftIdx = left;
        }
        
         left = 0; right = nums.length - 1; result = -1;
        int rightIdx = Integer.MIN_VALUE;
        while(left + 1 < right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
               rightIdx = Math.max(mid, rightIdx);
                //leftIdx = Math.min(mid, leftIdx);
                left = mid;
            }else if(nums[mid] > target){
                right = mid;
            }else{
                left = mid;
            }
        }
        
        if(nums[left] == target){
            rightIdx = left;
        }
        if(nums[right] == target){
            rightIdx = right;
        }
        
        if(leftIdx == Integer.MAX_VALUE && rightIdx == Integer.MIN_VALUE){
            return new int[]{-1, -1};
        }
        
        return new int[]{leftIdx, rightIdx};
        
        
    }
}
