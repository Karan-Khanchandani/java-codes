package problem;

import java.util.HashMap;
import java.util.Map;

/*
Problem Description:
Check if you can form palindrome by permuting given string
*/

public class Problem_13_1{


    public static boolean canFormPalindrome(String str){
        Map<Character, Integer> charFrequencies = new HashMap<Character, Integer>();

        for(int i = 0 ; i < str.length(); i++){
            char c = str.charAt(i);
            if(!charFrequencies.containsKey(c)){
                charFrequencies.put(c, 1);
            }else{
                charFrequencies.put(c, charFrequencies.get(c) + 1);
            }
        }

        //count if even with exeption of odd

        int oddCount = 0;
        for(Map.Entry<Character, Integer> p : charFrequencies.entrySet()){
            if((p.getValue()%2 != 0) && ++oddCount > 1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canFormPalindrome("racecar"));
        System.out.println(canFormPalindrome("aaa"));
        System.out.println(canFormPalindrome("a"));
        System.out.println(canFormPalindrome("abab"));
        System.out.println(canFormPalindrome("abc"));
    }
}