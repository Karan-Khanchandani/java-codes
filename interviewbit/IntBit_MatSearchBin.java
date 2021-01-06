package interviewbit;

public class Solution {
    public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
        int n = a.size();
        int m = a.get(0).size();
        int idx = -1;
        for (int i = 0; i < n; i++) {
            idx = Collections.binarySearch(a.get(i), b);
            if (idx >= 0) {
                return 1;
            }
        }
        return 0;
    }
}
