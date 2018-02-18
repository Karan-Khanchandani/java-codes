import java.util.LinkedList;
import java.util.List;

/**
 Write a program which takes as input an array of digits encoding a decimal number
D and updates the array to represent the number D + 1. For example, if the input
65is (1,2,9) then you should update the array to (1,3,0). Your algorithm should work
even if it is implemented in a language that has finite-precision arithmetic.
 */

 public class Problem_6_2{

    public static List<Integer> plusOne(List<Integer> list){
        int length = list.size() - 1;
        list.set(length, list.get(length) + 1);

        for(int i = length; i > 0 && list.get(i) == 10; i--){
            list.set(i, 0);
            list.set(i-1, list.get(i-1) + 1);
        }

        if(list.get(0) == 10){
            list.set(0, 0);
            list.add(0, 1);
        }

        return list;
    }

     public static void main(String[] args) {
         List <Integer> list = new LinkedList<Integer>();
         list.add(9);
         list.add(8);
         list.add(1);

         list = plusOne(list);

         for(int i = 0; i < list.size(); i++){
             System.out.print(list.get(i));
         }
         System.out.println();

         list.clear();

         list.add(9);
         list.add(9);
         list.add(9);

         list = plusOne(list);

         for(int i = 0; i < list.size(); i++){
             System.out.print(list.get(i));
         }
         System.out.println();

 }
}