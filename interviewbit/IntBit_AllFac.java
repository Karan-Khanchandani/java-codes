package interviewbit;

public class Solution {
    public ArrayList<Integer> allFactors(int A) {

        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> ans2 = new ArrayList<>();
        if (A == 0) {
            ans.add(0);
            return ans;
        }
        for (int i = 1; i <= Math.sqrt(A); i++) {
            if (A % i == 0) {
                ans.add(i);
                if (i * i != A) {
                    ans2.add(A / i);
                }
            }
        }
        Collections.reverse(ans2);
        ans.addAll(ans2);
        return ans;
    }
}
