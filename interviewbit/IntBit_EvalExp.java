package interviewbit;

public class Solution {
    public int evalRPN(ArrayList<String> A) {
        if(A.size() == 0 || A == null) return 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < A.size(); i++){
            String s = A.get(i);
            if(s.equals("+") || s.equals("-") ||
            s.equals("*") || s.equals("/") ){
                int num1 = st.pop();
                int num2 = st.pop();
                if(s.equals("+")){
                    st.push(num1+ num2);
                }else if(s.equals("-")){
                    st.push(num2 - num1);
                }else if(s.equals("*")){
                    st.push(num1*num2);
                }else{
                    st.push(num2/num1);
                }
            }else{
                st.push(Integer.parseInt(s));
            }
        }
        return st.peek();
    }
}
