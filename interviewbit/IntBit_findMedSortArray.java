package interviewbit;

public class Solution {
	// DO NOT MODIFY BOTH THE LISTS
	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
	    if(b.size() < a.size()){
	        return findMedianSortedArrays(b,a);
	    }
	    int x = a.size();
	    int y = b.size();
	    double ans = 0;
	    int low = 0, high = a.size();
	    while(low <= high){
	        int partitionX = (low + high)/2;
	        int partitionY = (x + y + 1)/2 - partitionX;
	        
	        int maxLeftX = (partitionX == 0)? Integer.MIN_VALUE : a.get(partitionX - 1);
            int minRightX = (partitionX == x)? Integer.MAX_VALUE : a.get(partitionX);
            
            int maxLeftY = (partitionY == 0)? Integer.MIN_VALUE : b.get(partitionY - 1);
            int minRightY = (partitionY == y)? Integer.MAX_VALUE : b.get(partitionY);
            
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
