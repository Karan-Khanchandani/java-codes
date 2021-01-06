package interviewbit;

public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        combineUtil(res, new ArrayList<>(), 0, 1, A, B);
        return res;
    }

    public void combineUtil(ArrayList<ArrayList<Integer>> list, ArrayList<Integer> temp, int currCount, int index, int n, int k) {
        if (currCount >= k) {
            list.add(new ArrayList<>(temp));
            return;
        }
        if (index > n) {
            return;
        } else {
            temp.add(index);
            combineUtil(list, temp, currCount + 1, index + 1, n, k);
            temp.remove(temp.size() - 1);
            combineUtil(list, temp, currCount, index + 1, n, k);
        }
    }
}
