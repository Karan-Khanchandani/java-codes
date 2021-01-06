package interviewbit;

public class Solution {
    public int divide(int A, int B) {
        if (B == 0 || (A == Integer.MIN_VALUE && B == -1)) return Integer.MAX_VALUE;

        int sign = ((A < 0) ^ (B < 0)) ? -1 : 1;
        long dividend = (A < 0) ? A * -1L : A * 1L;
        long divisor = (B < 0) ? B * -1L : B * 1L;
        int res = 0;
        while (dividend >= divisor) {
            long temp = divisor, multiple = 1;
            while (dividend >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            dividend -= temp;
            res += multiple;
        }
        return (sign == 1) ? res : -1 * res;
    }
}
