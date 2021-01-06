package interviewbit;

public class Solution {
    public int maxArea(ArrayList<Integer> A) {
        int start = 0, end = A.size() - 1;
        int area  = 0;
        while(start < end){
            area = Math.max(area, (end - start)*Math.min(A.get(start), A.get(end)));
            if(A.get(start) < A.get(end)){
                start++;
            }else{
                end--;
            }
        }
        
        return area;
    }
}
