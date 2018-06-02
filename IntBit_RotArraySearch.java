public class Solution {
	// DO NOT MODIFY THE LIST
	static int findPivot(final List<Integer> a){
	    int low = 0, high = a.size() -1;
	    while(low < high){
	        int mid = low + (high - low)/2;
	        if(a.get(mid).intValue() > a.get(mid + 1).intValue()){
	            return mid+1;
	        }
	        if(a.get(mid).intValue() < a.get(mid - 1).intValue()){
	            return mid;
	        }else{
	            if(a.get(low).intValue() < a.get(mid).intValue()){
	                low = mid + 1;
	            }else{
	                high = mid -1;
	            }
	        }
	    }
	    return -1;
	}
	
	static int bin_search(final List<Integer> a, int low, int high, int b){
	    while(low <= high){
	        int mid = low + (high - low)/2;
	        if(a.get(mid).intValue() == b){
	            return mid;
	        }else if(a.get(mid).intValue() < b){
	            low = mid+1;
	        }else{
	            high = mid - 1;
	        }
	    }
	    return -1;
	}
	public int search(final List<Integer> a, int b) {
	    if(a.size() == 0) return -1;
	    if(a.size() == 1){
	        if(a.get(0).intValue() == b) return 0;
	        return -1;
	    }
	    if(a.size() == 2){
	        if(a.get(0).intValue() == b){
	            return 0;
	        }
	        if(a.get(1).intValue() == b){
	            return 1;
	        }
	        return -1;
	    }
	    int pivotIdx = findPivot(a);
	    if(pivotIdx == -1){
	        int idx = bin_search(a, 0, a.size() - 1, b);
	        return idx;
	    }
	        int idx = bin_search(a, 0, pivotIdx - 1, b);
	        if(idx == -1){
	            idx = bin_search(a, pivotIdx, a.size() - 1, b);
	        }
	        return idx;
	}
}
