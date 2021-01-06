package leetcode;

class Solution {
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int maxLen = 0;
        for(String s: input.split("\n")){
            int numOfTabs = s.lastIndexOf("\t") + 1;
            
            int level = numOfTabs + 1;
            
            while(level < stack.size()) stack.pop();
            
            int len = s.length() + stack.peek() - numOfTabs + 1;
            stack.push(len);
            
            if(s.contains(".")){
                maxLen = Math.max(maxLen, len - 1);
            }
        }
        
        return maxLen;
    }
}
