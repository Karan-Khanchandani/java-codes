package problem;

import java.util.LinkedList;
import java.util.List;

/**
 * Problem Description:
 * 
 * Multiply two numbers
 */


 public class Problem_6_3{

    public static List<Integer> multiply(List<Integer> num1, List<Integer> num2) {

        List<Integer> num3 = new LinkedList<Integer>();

        for(int i = 0; i< num1.size() + num2.size(); i++){
            num3.add(i, 0);        
        }

        
        for(int i = num2.size() - 1, k = 1; i >= 0; i--, k++){

            int carry = 0;
            
            int num3_index = num3.size() - k;
            //System.out.println(num3_index);

            for(int j = num1.size() - 1; j >= 0; j--){

                int digitProd = num2.get(i)*num1.get(j);
                int sum = num3.get(num3_index) + digitProd + carry;
                num3.set(num3_index, sum%10);
                carry = sum/10;
                num3_index--;
            }
            
            if(carry != 0){
                num3.set(num3_index, num3.get(num3_index) + carry);
            }
            //check carry in end
            
           

   
   
        }
        return num3;
    }

     public static void main(String[] args) {

          List<Integer> num1 = new LinkedList<Integer>(); //135652588942101
         num1.add(1);
         num1.add(3);
         num1.add(5);
         num1.add(6);
         num1.add(5);
         num1.add(2);
         num1.add(5);
         num1.add(8);
         num1.add(8);
         num1.add(9);
         num1.add(4);
         num1.add(2);
         num1.add(1);
         num1.add(0);
         num1.add(1);

         List<Integer> num2 = new LinkedList<Integer>(); //1532663428899
         num2.add(1);
         num2.add(5);
         num2.add(3);
         num2.add(2);
         num2.add(6);
         num2.add(6);
         num2.add(3);
         num2.add(4);
         num2.add(2);
         num2.add(8);
         num2.add(8);
         num2.add(9);
         num2.add(9);
         
         List<Integer> num3 = new LinkedList<Integer>();

         num3 = multiply(num1, num2);

         for(int i = 0; i < num3.size(); i++){
             System.out.print(num3.get(i));
         }

         System.out.println();

     }
 }