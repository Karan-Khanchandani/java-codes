package interviewbit;

public class Solution {
    public int[] dNums(int[] A, int B) {
        
        if(B > A.length){
            int[] res = new int[1];
            return res;
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] res = new int[A.length - B + 1];
        int dist_count = 0;
        for(int i = 0; i < B; i++){
            if(hm.get(A[i]) == null){
                dist_count++;
                hm.put(A[i],1);
            }else{
                hm.put(A[i], hm.get(A[i]) + 1);
            }
        }
        res[0] = dist_count;
        
        for(int i = B; i < A.length;i++){
            //remove
            if(hm.get(A[i-B]) == 1){
                dist_count--;
                hm.remove(A[i-B]);
            }else{
                hm.put(A[i-B], hm.get(A[i-B]) - 1);
            }
            //add
            if(hm.get(A[i]) == null){
                dist_count++;
                hm.put(A[i],1);
            }else{
                hm.put(A[i], hm.get(A[i]) + 1);
            }
            
            res[i-B+1] = dist_count;
        }
        
        return res;
    }
}
