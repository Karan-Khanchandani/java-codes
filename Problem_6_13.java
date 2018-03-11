import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/*
Problem Description:
Generate a random permutation
*/

public class Problem_6_13{

    public static void randomize(List<Integer> perm, int k){
        Random r = new Random();
        for(int i = 0; i < k; i++){
            Collections.swap(perm, i, i + r.nextInt(perm.size() - i));
        }
    }

    public static List<Integer> generateRandomPermutation(int n){
        List<Integer> perm = new ArrayList<>();
        for(int i = 0; i < n; i++){
            perm.add(i);
        }

        randomize(perm, n);

        return perm;
    }

    public static void printList(List<Integer> list){
        System.out.print("< ");
        for(Integer i: list){
            System.out.print(i+ ", ");
        }
        System.out.print(" >");
        System.out.println();
    }
    public static void main(String[] args) {

        List<Integer> random_perm = generateRandomPermutation(5);
        //includes [0,5]

        printList(random_perm);
        
    }
}