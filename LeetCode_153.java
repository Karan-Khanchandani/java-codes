class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        while(right - left > 1) {
            int middle = (left + right) / 2;
            if (nums[middle] > nums[left]) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return nums[right];
    }
}
