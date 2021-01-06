package problem;/*
Problem Description:
Look and say
*/

public class Problem_7_8{

    public static String lookAndSay(int n){
        String s = "1";
        for(int i = 1; i < n; i++){
            s = nextNumber(s);
        }
        return s;
    }

    public static String nextNumber(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            int count = 1;
            while(i + 1 < s.length() && s.charAt(i) == s.charAt(i+1)){
                count++;
                i++;
            }
            sb.append(count);
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = lookAndSay(10);
        System.out.println(s);
    }
}