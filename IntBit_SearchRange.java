public class Solution {
    // DO NOT MODIFY THE LIST
    
    static int bin_search_lower(final List<Integer> a, int b){
        int low = 0, high = a.size() - 1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(a.get(mid) == b){
                ans = mid;
                high = mid -1;
            }else if(a.get(mid) < b){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }
    
    static int bin_search_upper(final List<Integer> a, int b){
        int low = 0, high = a.size() - 1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(a.get(mid) == b){
                ans = mid;
                low = mid + 1;
            }else if(a.get(mid) < b){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }
    
    public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        
        int lowerB = bin_search_lower(a, b);
        int upperB = bin_search_upper(a,b);
        if(lowerB == -1 && upperB == -1){
            return new ArrayList<>(Arrays.asList(-1,-1));
        }
        if(lowerB == -1){
            return new ArrayList<>(Arrays.asList(upperB, upperB));
        }
        if (upperB == -1){
            return new ArrayList<>(Arrays.asList(lowerB, lowerB));
        }
        
        return new ArrayList<>(Arrays.asList(lowerB, upperB));
    }
}
