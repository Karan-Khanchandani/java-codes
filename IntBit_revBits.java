public class Solution {
	public long reverse(long a) {
	    long res=0;
        for(int i=31;i>=0;i--){
            long bit= (a&1);
            a=a>>1;
            res=res+bit*(long)Math.pow(2,i);
            
        }
        
        return res;
	}
}
