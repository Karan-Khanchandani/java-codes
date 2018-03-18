import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_15 {

    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int k = 0; k < nums.length - 2; k++) {
            if ((k == 0) || (k > 0 && nums[k] != nums[k - 1])) {
                int sum = 0 - nums[k];
                int low = k + 1, high = nums.length - 1;

                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        result.add(new ArrayList<>(Arrays.asList(nums[k], nums[low], nums[high])));
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        low++;
                        high--;

                    } else if (nums[low] + nums[high] < sum) {
                        low++;
                    } else {
                        high--;
                    }
                }

            }

        }

        return result;
    }

    public static void printList(List<Integer> list) {
        System.out.print("[ ");
        for (Integer i : list) {
            System.out.print(i + ", ");
        }
        System.out.print("]");
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = new int[] { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> result = threeSum(nums);

        for (List<Integer> list : result) {
            printList(list);
        }

    }
}