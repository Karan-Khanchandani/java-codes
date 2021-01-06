package problem;/*
Compute real square root of a number
*/

public class Problem_12_5{

    private static enum Ordering {SMALLER, EQUAL, LARGER};

    public static double square_root(double num){
        double left, right, mid;
        if(num < 1.0){
            left = num;
            right = 1.0;
        }else{
            left = 1.0;
            right = num;
        }

        while(left <= right){
             mid = left + 0.5*(right - left);
             double midSquared = mid*mid;

             if(compare(midSquared, num) == Ordering.EQUAL){
                 return mid;
             }else if(compare(midSquared, num) == Ordering.LARGER){
                right = mid;
             }else{
                left = mid;
             }
            
        }

        return left;
    }

    public static Ordering compare(double a, double b){
        final double EPSILON = 0.000001;

        double diff = (a - b)/b;

        return diff < -EPSILON ? Ordering.SMALLER : (diff > EPSILON ?  Ordering.LARGER : Ordering.EQUAL);
    }
     public static void main(String[] args) {
        System.out.println(square_root(2.0));
        System.out.println(square_root(4.0));
        System.out.println(square_root(1.0));
        System.out.println(square_root(0.0));
        
    }
}