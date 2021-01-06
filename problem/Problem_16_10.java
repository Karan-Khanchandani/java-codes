package problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem Description:
Compute Gray code for given n, where n is the bit-size of each entry in gray code
*/

public class Problem_16_10{

    public static List<Integer> computeGrayCode(int num){
        if(num == 0){
            return new ArrayList<>(Arrays.asList(0));
        }

        List<Integer> grayCodeMinus1 = computeGrayCode(num - 1);

        int mask = 1<<(num-1);

        for(int i = grayCodeMinus1.size() -1; i >= 0; i--){
            grayCodeMinus1.add(grayCodeMinus1.get(i) | mask);
        }

        return grayCodeMinus1;
    }

    public static void printList(List<Integer> list){
        for(Integer i : list){
            System.out.println(Integer.toBinaryString(i));
        }
    }

    public static void main(String[] args) {
        List<Integer> grayCode = computeGrayCode(4);
        printList(grayCode);
    }
}