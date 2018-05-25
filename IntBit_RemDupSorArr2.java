public class Solution {
	public int removeDuplicates(ArrayList<Integer> a) {
	    int index = 0;

		if (a == null || a.size() == 0)
			return 0;
			
		if(a.size() == 1){
		    return 1;
		}
		int i = 0;	
	    while(i < a.size()){
	        int j = i;
	        int count = 0;
	        while(j < a.size() && a.get(i).intValue() == a.get(j).intValue()){
	            j++;
	            count++;
	        }
	        if(count < 2){
	            a.set(index++,a.get(i));
	        }else{
	            a.set(index++,a.get(i));
	            a.set(index++,a.get(i));
	        }
	        i = j;
	    }
	    return index;
	}
}
