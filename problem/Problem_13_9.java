package problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.List;

/*
Problem Description:

Find the longest subarray with distinct entries
*/

public class Problem_13_9 {

    public static int SubarrayWithDistinctElemLenght(List<String> stream){
        int result = 0;
        HashMap<String, Integer> mostFrequentIdx = new HashMap<>();
        int longestDistinctElemStartIdx = 0;

        for(int i = 0; i < stream.size(); i++){
            String s = stream.get(i);
            Integer idx = mostFrequentIdx.put(s,i);
            if(idx != null){
                if(idx >= longestDistinctElemStartIdx){
                result = Math.max(result, i - longestDistinctElemStartIdx);
                longestDistinctElemStartIdx = idx + 1;
                }
            }

        }
        result = Math.max(result, stream.size() - longestDistinctElemStartIdx);

        return result;
    }

    public static void printList(List<String> stream) {
        for (String s : stream) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<String> stream = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String input = null;
        do {
            input = sc.next();
            if (!input.equals("-1"))
                stream.add(input);
        } while (!input.equals("-1"));
        sc.close();
        printList(stream);


        System.out.println(SubarrayWithDistinctElemLenght(stream));

    }
}