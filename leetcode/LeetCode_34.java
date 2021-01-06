package leetcode;/*
Problem Description:

Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].


 */

public class LeetCode_34{
    public static int[] searchRange(int[] nums, int target) {
        
        if(nums.length == 0){
            return new int[]{-1, -1};
        }
        
        int startIdx = bs_first(nums, 0, nums.length - 1, target);
        int endIdx = bs_last(nums, 0, nums.length - 1, target);
        
        return new int[]{startIdx, endIdx};
    }
    
    public static int bs_first(int[] nums, int start, int end, int target){
        
        int resultIdx = -1;
        while(start <= end && start >= 0 && end < nums.length){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                resultIdx = mid;
                end = mid -1;
            }else if(nums[mid] < target){
                start = mid+1;
            }else{
                end = mid -1;
            }
            
        }
        
        return resultIdx;
    }
    
    public static int bs_last(int[] nums, int start, int end, int target){
        
        int resultIdx = -1;
        while(start <= end && start >= 0 && end < nums.length){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                resultIdx = mid;
                start = mid + 1;
            }else if(nums[mid] < target){
                start = mid+1;
            }else{
                end = mid -1;
            }
            
        }
        
        return resultIdx;
    }

    public static void main(String[] args) {
        int[] result = searchRange(new int[] {5, 7, 7, 8, 8, 10}, 8);
        System.out.println("[ " + result[0] + " ," + result[1] + " ]");

        result = searchRange(new int[] {1}, 1);
        System.out.println("[ " + result[0] + " ," + result[1] + " ]");

        result = searchRange(new int[] {}, 8);
        System.out.println("[ " + result[0] + " ," + result[1] + " ]");

        result = searchRange(new int[] {7, 7}, 7);
        System.out.println("[ " + result[0] + " ," + result[1] + " ]");
    }
}