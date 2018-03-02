import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/*
Problem Description:

Find the kth largest element in list
*/

public class Problem_12_8 {

    public static int kth_largest(List<Integer> arr, int k) {
        int left = 0, right = arr.size() - 1;
        Random random = new Random(0);

        while (left <= right) {
            int pivot = random.nextInt(right - left + 1) + left;
            pivot = partition(arr, left, right, pivot);

            if (pivot == k - 1) {
                return arr.get(pivot);
            } else if (pivot < k - 1) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }

        return -1;

    }

    public static class GreaterThan implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            return (a > b) ? -1 : (a.equals(b) ? 0 : 1);

        }

        public static final GreaterThan GREATER_THAN = new GreaterThan();
    }

    public static int partition(List<Integer> arr, int left, int right, int pivot) {

        Integer pivotValue = arr.get(pivot);
        int pivotIdx = left;
        GreaterThan cmp = new GreaterThan();
        Collections.swap(arr, pivot, right);
        for (int i = left; i < right; i++) {
            if (cmp.compare(arr.get(i), pivotValue) < 0) {
                Collections.swap(arr, i, pivotIdx++);
            }
        }
        Collections.swap(arr, pivotIdx, right);
        return pivotIdx;
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(3, 2, 1, 45, 4, 11, 23, 22));
        System.out.println(kth_largest(nums, 1));
    }
}