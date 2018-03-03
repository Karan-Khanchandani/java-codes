import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/*
Find lenght longest interval containing all integers in between in a list
*/

public class Problem_13_10{
    public static int longestInterval(List<Integer> nums){
        int result = 0;
        HashSet<Integer> hashSet = new HashSet<>(nums);
        while(!hashSet.isEmpty()){
            int a = hashSet.iterator().next();
            hashSet.remove(a);

            int lowerBound = a - 1;
            while(hashSet.contains(lowerBound)){
                hashSet.remove(lowerBound);
                lowerBound--;
            }

            int upperBound = a + 1;
            while(hashSet.contains(upperBound)){
                hashSet.remove(upperBound); 
                upperBound++;
            }
            result= Math.max(result, upperBound - lowerBound - 1);
        }
        return result;

    }
    public static void main(String[] args) {
        Integer a[] = new Integer[]{3, -2, 7, 9,8, 1,2,0, -1,5,8};
        List<Integer> nums = new ArrayList<Integer>(Arrays.asList(a));
        
        System.out.println(longestInterval(nums));


    }
}