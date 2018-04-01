class Solution {
    
    public static final String[] MAPPING = {"","","abc", "def", "ghi", "jkl","mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        
      List<String> res = new ArrayList<>();
        if(digits.equals("") || digits == null){
          return res;
        }
      letterCombinationsHelper(res,"",0,digits);
        return res;
    }
    
    public void letterCombinationsHelper(List<String> res,String s, int count, String digits){
        if(count == digits.length()){
            res.add(s);
            return;
        }
        
        int strIdx = Character.getNumericValue(digits.charAt(count));
        
        String currentStr = MAPPING[strIdx];
        for(int i = 0; i < currentStr.length(); i++){
            letterCombinationsHelper(res, s + currentStr.charAt(i), count+1, digits);
        }
        
        return;
    }
    
}
