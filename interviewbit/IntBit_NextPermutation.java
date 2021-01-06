package interviewbit;

public class Solution {
	public void nextPermutation(ArrayList<Integer> a) {
	    int last = a.get(a.size() - 1);
	    
	    int idx = -1;
	    for(int i = a.size() - 1; i>=1 ; i--){
	        if(a.get(i).intValue() > a.get(i-1).intValue()){
	            idx = i-1;
	            break;
	        }
	    }
	    if(idx == -1){
	        Collections.sort(a);
	        
	    }else{
	        int minIdx = -1;
	        int ans = Integer.MAX_VALUE;
	        for(int i = idx + 1; i < a.size(); i++){
	            if(a.get(i).intValue() > a.get(idx).intValue()){
	                if(ans > a.get(i).intValue()){
	                    ans = a.get(i).intValue();
	                    minIdx = i;
	                }
	            }
	        }
	        Collections.swap(a, idx, minIdx);
	        Collections.sort(a.subList(idx+1, a.size()));
	    }
	    
	    
	}
}
