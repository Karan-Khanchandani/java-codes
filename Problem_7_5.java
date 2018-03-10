/*
Problem Description:
Check if string is palindrome without considering case and only consider alphanumeric
*/

public class Problem_7_5{
    public static boolean isPalindrome(String s){
        int i = 0, j = s.length() -1;
        while( i < j ){
            while(!Character.isLetterOrDigit(s.charAt(i)) && i < j){
                i++;
            }
            while(!Character.isLetterOrDigit(s.charAt(j)) && i < j){
                j--;
            }

            if(Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--))){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "";
        System.out.println(isPalindrome(s));
        s = "Able was I, ere I saw Elba!";
        System.out.println(isPalindrome(s));
    }
}