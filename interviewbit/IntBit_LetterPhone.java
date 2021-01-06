package interviewbit;

public class Solution {

    static String[] keyMap = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public ArrayList<String> letterCombinations(String A) {

        //2332
        ArrayList<String> res = new ArrayList<>();
        if (A == null || A.length() == 0) return res;
        letterCombinationsUtil(res, new StringBuilder(), A, 0);
        return res;
    }

    public void letterCombinationsUtil(ArrayList<String> res, StringBuilder sb, String A, int index) {
        if (index == A.length()) {
            res.add(sb.toString());
            return;
        }

        //get the num
        int key = (int) (A.charAt(index) - '0');
        String keys = keyMap[key];
        for (int i = 0; i < keys.length(); i++) {
            //abc
            sb.append(keys.charAt(i));
            letterCombinationsUtil(res, sb, A, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
 
