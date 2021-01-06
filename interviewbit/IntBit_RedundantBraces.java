package interviewbit;

public class Solution {
    public int braces(String A) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < A.length(); i++){
            Character c = A.charAt(i);
            if(c == '+' || c == '-' || c == '*' || c =='/'){
                st.push(c);
            }else if(c == '('){
                st.push(c);
            }else if(c ==')'){
                if(!st.isEmpty() && (st.peek() == '+' || st.peek() == '-' ||
                st.peek() == '*' || st.peek() == '/'))st.pop();
                else return 1;
                if(!st.isEmpty() && st.peek() == '(')st.pop();
                else return 1;
            }else{
                continue;
            }
        }
        return 0;
        
    }
}
