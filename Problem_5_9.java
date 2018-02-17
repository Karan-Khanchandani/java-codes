/*
Problem Description:
Write a program that takes an integer and determines if that integer's representation
as a decimal string is a palindrome.
*/

public class Problem_5_9{

    public static boolean isPalindrome(int x){
        if(x < 0){
            return false;
        }

        int numDigits = (int)Math.floor(Math.log10(x)) + 1;
        int number = x;
        int mask = (int)Math.pow(10, numDigits - 1);
        for( int i = 0; i< numDigits / 2; i++){
            //extract lsb msb
            int lsb = number%10;        
            int msb = number/mask;
            if(lsb != msb){
                return false;
            }
            //remove lsb msb
            number = number%mask;
            number /= 10;
            mask /= 100;
            
        }
        
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(555));
        System.out.println(isPalindrome(9));
        System.out.println(isPalindrome(123321));
        System.out.println(isPalindrome(12234321));
        System.out.println(isPalindrome(-555));
    }
}