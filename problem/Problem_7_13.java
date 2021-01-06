package problem;/*
Problem Description:
Find substring Rabin Karp Algo
*/

public class Problem_7_13{

    public static int RabinKarp(String s, String t){
        if(s.length() > t.length()){
            return -1;
        }

        //Calculate hash;
        int tHash = 0, sHash = 0, powerS = 1;
        final int BASE = 26;
        for(int i = 0; i < s.length(); i++){
            powerS = (i > 0) ? powerS*BASE : 1;
            sHash = sHash*BASE + s.charAt(i);
            tHash = tHash*BASE + t.charAt(i);
        }

        for(int i = s.length(); i < t.length(); i++){
            if(tHash == sHash && t.substring(i - s.length(), i).equals(s)){
                return (i - s.length());
            }
            //update tHash
            tHash -= t.charAt(i - s.length())*powerS;
            tHash = tHash*BASE + t.charAt(i);
        }

        if(sHash == tHash && t.substring(t.length() - s.length()).equals(s)){
            return (t.length() - s.length());
        }

        return -1;
    }

    public static void main(String[] args) {
        String s = "CGC";
        String t = "GACGCAAB";

        int index = RabinKarp(s,t);
        System.out.println(index);
    }
}