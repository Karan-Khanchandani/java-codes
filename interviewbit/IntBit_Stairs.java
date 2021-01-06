package interviewbit;

public class Solution {
    public int climbStairs(int A) {
        if (A == 0 || A == 1) return A;
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 0; i < A; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
