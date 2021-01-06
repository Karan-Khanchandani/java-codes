package leetcode;

class Solution {
    public int search(int[] nums, int target) {
        //find pivot each element have next greater than them execept pivot
       int pivot = findPivot(nums, 0, nums.length - 1);
        if(pivot == -1){
            return binary_search(nums, 0, nums.length - 1, target);
        }
        
        if(nums[pivot] == target){
            return pivot;
        }
        if(nums[0] > target){
            return binary_search(nums, pivot+1, nums.length -1 , target);
        }
        return binary_search(nums, 0, pivot - 1, target);
    }
    
    public int binary_search(int[] nums, int low, int high, int target){
        if(low > high){
            return -1;
        }
        
        int mid = low + (high - low)/2;
        if(nums[mid] == target){
            return mid;
        }else if(nums[mid] < target){
            return binary_search(nums, mid + 1, high, target);
        }else{
            return binary_search(nums, low, mid - 1, target);
        }
        
    }
    
    public int findPivot(int[] arr, int low, int high){
        if (high < low)  return -1;
   if (high == low) return low;
 
   int mid = (low + high)/2;   /*low + (high - low)/2;*/
   if (mid < high && arr[mid] > arr[mid + 1])
       return mid;
   if (mid > low && arr[mid] < arr[mid - 1])
       return (mid-1);
   if (arr[low] >= arr[mid])
       return findPivot(arr, low, mid-1);
   return findPivot(arr, mid + 1, high);
    }
}
