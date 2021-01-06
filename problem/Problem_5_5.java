package problem;/*
Problem description
Write a program that multiplies two nonnegative integers. The only operators you
are allowed to use are
• assignment,
• the bitwise operators », «, | , &, “ and
• equality checks and Boolean combinations thereof.
*/


public class Problem_5_5{

    public static long addBitnums(long a, long b){
        long sum = 0, carryin = 0, k = 1;
        long ans = 0, tempA = a, tempB = b;

        while(tempA != 0 || tempB != 0){

            long ka = k & a, kb = k & b;
            long carryout = (ka & kb)|(ka & carryin)|(kb & carryin);
            sum |= ka^kb^carryin;
            carryin = carryout << 1;
            k <<= 1;
            tempA >>>= 1;
            tempB >>>= 1;

        }

        return sum|carryin;
    }

    public static long multiply(long x, long y){
        long ans = 0;
        while(x != 0){

            if((x & 1) != 0){
                ans = addBitnums(ans, y);
            }
            x >>= 1;
            y <<= 1;
        }
        return ans;
    }

    public static void main(String[] args) {

        System.out.println(multiply(15, 15));
        System.out.println(multiply(1000, 54));

    }
}