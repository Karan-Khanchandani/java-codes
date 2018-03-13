/*
Problem Description:
Find GCD without using mod, mutiply or division
*/

public class Problem_25_1{
    public static int gcd(int a, int b){
        if(a == b){
            return a;
        }else{
            //if both are even
            if((a & 1) == 0 && (b & 1) == 0){
                return (gcd((a >>> 1), (b >>> 1))) << 1;
            }else if(((a & 1) == 0) && ((b & 1) != 0)){
                return gcd((a >>> 1), b);
            }else if(((a & 1) != 0) && ((b & 1) == 0)){
                return  gcd(a, (b >>> 1));
            }else{
                return (a > b) ? gcd(a- b, b) : gcd(a, b-a);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(gcd(2,1));
        System.out.println(gcd(3,1));
        System.out.println(gcd(2,4));
        System.out.println(gcd(3,9));
        System.out.println(gcd(4,16));
        System.out.println(gcd(2,3));

    }
}