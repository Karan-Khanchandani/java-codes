package interviewbit;

public class Solution {

    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        Collections.sort(arrive);
        Collections.sort(depart);
        int arr = 0, dep = 0;
        while (arr < arrive.size()) {
            K--;
            arr++;

            if (K == 0 && arr < arrive.size() && dep < depart.size()) {
                if (arrive.get(arr) >= depart.get(dep)) {
                    dep++;
                    K++;
                }
            }

            if (K < 0) return false;
        }
        return true;
    }
}
