package interviewbit;

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int trap(final List<Integer> A) {
        int leftMax = 0, rightMax = 0;
        int left = 0, right = A.size() -1;
        int res = 0;
        while(left <= right){
            if(A.get(left) <= A.get(right)){
                if(A.get(left) >= leftMax) leftMax = A.get(left);
                else res += leftMax - A.get(left);
                left++;
            }else{
                if(A.get(right) >= rightMax) rightMax = A.get(right);
                else res += rightMax - A.get(right);
                right--;
            }
        }
        return res;
        
    }
}
