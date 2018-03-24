/*
Given an integer array sorted in ascending order, write a function to search target in nums.  If target exists, then return its index, otherwise return -1. However, the array size is unknown to you. You may only access the array using an ArrayReader interface, where ArrayReader.get(k) returns the element of the array at index k (0-indexed).

You may assume all integers in the array are less than 10000, and if you access the array out of bounds, ArrayReader.get will return 2147483647.


*/

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0, high = 1;
        int val = reader.get(low);
        
        while(val < target){       
            if(reader.get(2*high) == 2147483647){
                break;
        }else{
               low = high; 
               
               high = 2*high;  
                val = reader.get(high);
            }
    }
        
       return binary_search(reader, low, 2*high, target);
}
    
    public int binary_search(ArrayReader reader, int l, int h, int target){
        int low = l, high = h;
        
        while(low <= high){
          int mid = low + (high - low)/2; 
            int midVal = reader.get(mid);
            if( midVal == target){
                return mid;
            }else if(midVal < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        
        return -1;
    }
}
