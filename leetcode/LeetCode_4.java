package leetcode;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length < nums1.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int x = nums1.length;
        int y = nums2.length;
        double ans = 0.0;
        int low = 0, high = nums1.length;
        while(low <= high){
            int partitionX = (low + high)/2;
            int partitionY = (x + y + 1)/2 - partitionX;
            
            int maxLeftX = (partitionX == 0)? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == x)? Integer.MAX_VALUE : nums1[partitionX];
            
            int maxLeftY = (partitionY == 0)? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == y)? Integer.MAX_VALUE : nums2[partitionY];
            
            if(maxLeftX <= minRightY && maxLeftY <= minRightX){
                if((x + y)%2 == 0){
                    ans =  (double)(Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2.0;
                    break;
                }else{
                    ans = (double)Math.max(maxLeftX, maxLeftY);
                    break;
                }
            }else if(maxLeftX > minRightY){
                high = partitionX - 1;
            }else{
                low = partitionX + 1;
            }
        }
        return ans;
        
    }
}
