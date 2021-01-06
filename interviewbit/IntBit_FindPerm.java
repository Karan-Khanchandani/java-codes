package interviewbit;

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> findPerm(final String A, int B) {
        int min = 1, max = B;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            Character c = A.charAt(i);
            if (c == 'I') {
                res.add(min);
                min++;
            } else {
                res.add(max);
                max--;
            }
        }
        res.add(min);
        return res;
    }
}
