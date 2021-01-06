package interviewbit;

public class Solution {

    static int upperbound(ArrayList<Integer> arr, int key) {
        int low = 0;
        int high = arr.size();
        while (low < high) {
            final int mid = (low + high) / 2;
            if (key >= arr.get(mid)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int n = A.size(), m = A.get(0).size();

        for (int i = 0; i < n; i++) min = Math.min(min, A.get(i).get(0));
        for (int i = 0; i < n; i++) max = Math.max(max, A.get(i).get(m - 1));

        int desired = (n * m + 1) / 2;
        while (min < max) {
            int mid = min + (max - min) / 2;
            int place = 0;
            for (int i = 0; i < n; i++) {
                int temp = upperbound(A.get(i), mid);
                place += temp;
            }
            if (place < desired) min = mid + 1;
            else max = mid;

        }
        return min;
    }
}
