/*
Problem Description:
Convert string to integer
*/

public class Problem_7_1{

    public static int convertStringtoInteger(String s){
        int power = 0, result = 0;
        for(int i = s.length() -1; i >=0 ; i--){
            Character c = s.charAt(i);
            if(c == '-'){
                result = -1*result;
            }else{
                result += ((int)(c - '0'))*Math.pow(10, power);
                power++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int result1 = convertStringtoInteger("123");
        System.out.println(result1);
        int result2 = convertStringtoInteger("-123");
        System.out.println(result2);

        System.out.println(result1 + result2);
    }
}