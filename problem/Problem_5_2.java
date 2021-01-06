package problem;/*
Problem Description: 
A 64-bit integer can be viewed as an array of 64 bits, with the bit at index 0 corre¬
sponding to the least significant bit (LSB), and the bit at index 63 corresponding to
the most significant bit (MSB). Implement code that takes as input a 64-bit integer
and swaps the bits at indices i and j.
*/

public class Problem_5_2 {

    public static long swapBits(long x, int i, int j) {
        if (((x >>> i) & 1) != ((x >>> j) & 1)) {
            long bitmask = (1L << i) | (1L << j);
            x ^= bitmask;
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(swapBits(11, 1, 2));
    }
}