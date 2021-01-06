package leetcode;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if(n == 0){
            return ans;
        }
        
        String s = "";
        generateParanthesis(s, n , n, ans);
        return ans;
    }
    
    public void generateParanthesis(String s, int numLeft, int numRight,  List<String> ans){
    
        if(numLeft == 0 && numRight == 0){
            ans.add(s);
        }else{
            if(numLeft > 0){
                generateParanthesis(s + "(", numLeft - 1, numRight, ans);
            }
            
            if(numRight > numLeft){
                 generateParanthesis(s + ")",  numLeft, numRight - 1, ans);
            }
        }
        
    }
}
