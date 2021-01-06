package interviewbit;

public class Solution {
    public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {
        int m = A.size();
        int n = A.get(0).size();
        if(m == 0 || n == 0) return 0;
        
        int maxArea = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        
        Arrays.fill(left, 0);
        Arrays.fill(right, n);
        Arrays.fill(height, 0);
        
        for(int i = 0; i < m; i++){
            int curr_left = 0;
            int curr_right = n;
            
            for(int j = 0; j < n; j++){
                if(A.get(i).get(j) == 1){
                    left[j] = Math.max(left[j], curr_left);
                }else{
                    left[j] = 0;
                    curr_left = j+1;
                }
            }
            
            for(int j = n-1; j >= 0; j--){
                if(A.get(i).get(j) == 1){
                    right[j] = Math.min(right[j], curr_right);
                }else{
                    curr_right = j;
                    right[j] = n;
                }
            }
            
            for(int j = 0; j < n; j++){
                if(A.get(i).get(j) == 1){
                    height[j]++;
                }else{
                    height[j] = 0;
                }
            }
            
            for(int j = 0; j < n; j++){
                maxArea = Math.max(maxArea, (right[j] - left[j])*height[j]);
            }
        }
        
        return maxArea;
    }
}
