package interviewbit;

public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        if(A == null || A.size() == 0)return A;
        
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < A.size(); i++){
            int curr = A.get(i);
            while(!st.isEmpty() && st.peek() >= curr)st.pop();
            
            if(st.isEmpty())res.add(-1);
            else res.add(st.peek());
            st.push(curr);
        }
        return res;
    }
}
