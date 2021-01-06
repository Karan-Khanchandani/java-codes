package problem;/*
Problem Description:
Given two positive integers, compute their quotient, using only the addition, sub¬
traction, and shifting operators.
*/

public class Problem_5_6{

    public static long divide(long x, long y){
        if(y == 0){
            throw new ArithmeticException("Cannot divide by zero");
        }
        int power = 32;
        long ypower = y << power;
        long result = 0;
        while(x != 0){
            while(ypower > x){
                ypower >>>= 1;
                power--;
            }
            x -= ypower;

            result += (1L << power);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(divide(24,5));
        System.out.println(divide(24,6));
        System.out.println(divide(1,0));
    }
}