public class Solution {
    public int lengthOfLongestSubstring(String A) {
        if(A == null || A.length() == 0) return 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0, start = 0, end = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < A.length(); i++){
           Character c = A.charAt(i);
           if(map.containsKey(c)){
               start = Math.max(start, map.get(c) + 1);
           }
           map.put(c,i);
           ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }
}
