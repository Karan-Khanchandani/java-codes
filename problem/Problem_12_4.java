package problem;

import java.util.Scanner;

/*
Problem Description:
Find the largest number whose square is less than or equal to input
 */

 public class Problem_12_4{

    public static int findLargest(int k){
        long left = 0, right = k;
        while(left <= right){
            long mid = left + (right - left)/2;
            long midSquared = mid*mid;

            if(midSquared <= k){
                left = mid+1;
            }else{
                right = mid -1;
            }
        }
        return (int)left - 1;
    }

     public static void main(String[] args) {
         int k;
         Scanner sc = new Scanner(System.in);
         do{
            k = sc.nextInt();
            System.out.println(findLargest(k));
         }while(k != -1);
     }
 }