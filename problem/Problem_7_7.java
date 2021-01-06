package problem;

import java.util.ArrayList;
import java.util.List;

/*
Compute all mnemonics of phone number
*/

public class Problem_7_7{

    public static List<String> findMnemonics(String number){
        List<String> mnemoics = new ArrayList<>();
        char[] partial_mnemonics = new char[number.length()];

        findMnemonicsHelper(0, number, mnemoics, partial_mnemonics);
        return mnemoics;
    }

    public static final String[] MAPPING = {"0", "1" , "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

    public static void findMnemonicsHelper(int mnemoics_generate_so_far, String number, List<String> mnemoics, char[] partial_mnemonics){

        if(mnemoics_generate_so_far == number.length()){
            mnemoics.add(new String(partial_mnemonics));
        }else{

        for(int i = 0; i < MAPPING[(int)(number.charAt(mnemoics_generate_so_far) - '0')].length(); i++){
            char c = MAPPING[(int)(number.charAt(mnemoics_generate_so_far) - '0')].charAt(i);

            partial_mnemonics[mnemoics_generate_so_far] = c;
            findMnemonicsHelper(mnemoics_generate_so_far+1, number, mnemoics, partial_mnemonics);
        }
    }
        
    }

    public static void printList(List<String> list){
        for(String s: list){
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
       List<String> mnemoics = findMnemonics("2276696"); 
       printList(mnemoics);
    }
}