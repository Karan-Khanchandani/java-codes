package interviewbit;

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
        int start = 0, end = 1;
       int cur_petrol=A.get(start) - B.get(start);
        while(start!=end || cur_petrol<0)
        {
        while(cur_petrol<0 && start!=end)
        {
        if(start < A.size())
        cur_petrol-=A.get(start)-B.get(start);
        start=(start+1)%A.size();
        if(start==0)return -1;
        }
        if(end < A.size())
        cur_petrol+=A.get(end)-B.get(end);
        end=(end+1)%A.size();
        }
        return start;
    }
}
