package problem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
Problem Description:
Check in dictionary if one string can be converted to another by changing one character at a time
return the shortest num of transformation
*/


public class Problem_19_7{

    private static class StringWithDistance{
        public String candidateString;
        public int distance;

        public StringWithDistance(String candidateString, int distance){
            this.candidateString = candidateString;
            this.distance = distance;
        }
    }

    public static int transformString(String s, String t, Set<String> dictionary){
        Queue<StringWithDistance> queue = new LinkedList<>();
        dictionary.remove(s);
        queue.add(new StringWithDistance(s, 0));

        while(!queue.isEmpty()){

            StringWithDistance sd = queue.peek();
            if(sd.candidateString.equals(t)){
                return sd.distance;
            }
            String str = sd.candidateString;
            
            for(int i = 0; i < sd.candidateString.length(); i++){
                String start = (i == 0) ? "": str.substring(0, i);
                String end = (i+1) < str.length() ? str.substring(i+1) : "";
                for(int j = 0; j< 26;  j++){
                    String cand = start + (char)('a' + j) + end;
                    if(dictionary.contains(cand)){
                        
                        queue.add(new StringWithDistance(cand, sd.distance + 1));
                        dictionary.remove(cand);
                    }
                }
            }

            queue.remove();

        }

        return -1;
    }

    public static void main(String[] args) {
        String s = "bat";
        String t = "dag";
        Set<String> dictionary = new HashSet<>(Arrays.asList("bat", "cot", "dog", "dag", "dot", "cat"));
        
        int result = transformString( s,  t,  dictionary);

        if(result == -1){
            System.out.println("Conversion not possible");
        }else{
            System.out.println(result);
        }
    }
}