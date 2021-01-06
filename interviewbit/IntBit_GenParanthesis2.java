package interviewbit;

public class Solution {
    public ArrayList<String> generateParenthesis(int A) {
        ArrayList<String> res = new ArrayList<>();
        if(A == 0) return res;
        generateParanthesisUtil(res, "", 0, 0, A);
        return res;
    }
    
    public void generateParanthesisUtil(ArrayList<String> res, String s, int open, int close, int n){
        if(open == n && close == n){
            res.add(new String(s));
            return;
        }else{
            if(open < n){
                generateParanthesisUtil(res, s + "(", open + 1, close, n);
            }
            if(close < open){
                generateParanthesisUtil(res, s + ")", open, close + 1, n);
            }
        }
    }
}
