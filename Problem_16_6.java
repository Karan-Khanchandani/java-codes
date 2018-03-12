import java.util.ArrayList;
import java.util.List;

/*
Problem Description:
Generate valid paranthesis of size n
*/

public class Problem_16_6{

    public static List<String> getAllValidParan(int n){
        List<String> valid_paran = new ArrayList<>();

        getAllValidParanHelper(valid_paran, n-1, "()");

        return valid_paran;
    }

    public static void getAllValidParanHelper(List<String> valid_paran, int count_to_be_matched, String prefix){
        if(count_to_be_matched == 0){
            valid_paran.add(prefix);
            return;
        }else{

            getAllValidParanHelper(valid_paran, count_to_be_matched-1, prefix + "()");

            getAllValidParanHelper(valid_paran, count_to_be_matched-1, "(" + prefix + ")");
        }
    }

    public static void printList(List<String> list){
  
        for(String s : list){
            System.out.println(s);
        }
    
    }

    public static void main(String[] args) {
        List<String> valid_paran = getAllValidParan(5);
        
        printList(valid_paran);
    }
}