package leetcode;/*
Problem Description:

The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.
*/


public class LeetCode_461{

    public static int hammingDistance(int x, int y) {
        int result = x^y;
        int count = 0;
        while(result > 0){
            if((result & 1) == 1){
                count++;
            }
            result >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(4,1));
    }
}