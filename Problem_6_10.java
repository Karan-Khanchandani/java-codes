import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Problem Description:
Calculate the next permutation
Print all permutations
 */

public class Problem_6_10{

    public static List<Integer> nextPermutation(List<Integer> perm){
        int k = perm.size() -2;
        while(k >= 0 && perm.get(k) > perm.get(k+1)){
            k--;
        }

        if(k == -1){
            return Collections.emptyList();
        }
        for( int i = k+1; i < perm.size(); i++){
            if(perm.get(i) > perm.get(k)){
                Collections.swap(perm, i, k);
                break;
            }
        }
        
        Collections.reverse(perm.subList(k+1, perm.size()));

        return perm;
    }

    public static void printList(List<Integer> perm){
        for(Integer i : perm){
            System.out.print(i + " ,");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> perm = new ArrayList<>(Arrays.asList(6,2,1,5,4,3,0));
        List<Integer> perm1 = new ArrayList<>(Arrays.asList(6,5,4,3,2,1,0));;
        
       perm = nextPermutation(perm);
        printList(perm);
        perm = nextPermutation(perm1);
        printList(perm);
    }
}