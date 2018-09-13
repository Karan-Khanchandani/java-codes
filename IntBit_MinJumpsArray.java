public class Solution {
    public int jump(ArrayList<Integer> A) {
       int n=A.size();
        if(n<=1) return 0;
        int max_reach=A.get(0),step=A.get(0),jump=1;
        for(int i=1;i<n-1;i++){
            max_reach=Math.max(max_reach,i+A.get(i));
            step--;
            if(step<0) return -1;
            if(step==0){
             jump++;
             step=max_reach-i; 
            }
        }
        if(max_reach>=n-1) return jump;
        return -1;
    }
}
