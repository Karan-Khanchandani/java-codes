import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem Description:
Generate power set of a set
*/

public class Problem_16_4{

    private static final double LOG_2 = Math.log(2);

    public static List<List<Integer>> getPowerSet(List<Integer> inputSet){
        List<List<Integer>> powerSet = new ArrayList<>();
        for(int i = 0; i < (1 << inputSet.size()); i++){
            List<Integer> subSet = new ArrayList<>();
            int binaryDigit = i;
            while(binaryDigit > 0){
                subSet.add(inputSet.get((int)(Math.log(binaryDigit & ~(binaryDigit - 1))/LOG_2)));
                binaryDigit &= (binaryDigit - 1);
            }
            powerSet.add(new ArrayList<>(subSet));

        }
        return powerSet;
    }

    public static void printList(List<Integer> list){
        System.out.print("< ");
        for(Integer i : list){
            System.out.print(i + " ");
        }
        System.out.print(">");
        System.out.println();
    }

    public static void main(String[] args) {
        List<List<Integer>> powerSet = getPowerSet(new ArrayList<>(Arrays.asList(1,2,3,4)));

        for(int i = 0 ; i < powerSet.size(); i++){
            printList(powerSet.get(i));
        }
    }
}