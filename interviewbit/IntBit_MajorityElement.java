package interviewbit;

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int majorityElement(final List<Integer> A) {
         int major=A.get(0), count = 1;
        for(int i=1; i<A.size();i++){
            if(count==0){
                count++;
                major=A.get(i);
            }else if(major==A.get(i)){
                count++;
            }else count--;
            
        }
        return major;
    }
}
