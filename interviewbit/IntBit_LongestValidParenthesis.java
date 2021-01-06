package interviewbit;

public class Solution {
    public int longestValidParentheses(String A) {
        if(A.equals("")) return 0;
        boolean[] valid = new boolean[A.length()];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < A.length(); i++){
            Character c = A.charAt(i);
            if(c == '('){
                st.push(i);
            }else{
                if(!st.isEmpty())
               valid[st.pop()] = valid[i] = true; 
            }
        }
        
        int max = 0, count = 0;
        for(int i = 0; i < valid.length; i++){
            if(valid[i]){
                count++;
                max = Math.max(max, count);
            }else{
                count = 0;
            }
        }
        return max;
    }
}
