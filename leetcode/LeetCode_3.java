package leetcode;

import java.util.Map;
import java.util.HashMap;

public class LeetCode_3 {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        int result = 0;
        int duplicate_free_index_so_far = 0;
        
        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            Integer dupIdx = hm.put(c , i);
            
            if(dupIdx != null){
                if(dupIdx >= duplicate_free_index_so_far){
                    result = Math.max(result, i - duplicate_free_index_so_far);
                    duplicate_free_index_so_far = dupIdx +1;
                }
            }                
        }
        
        result = Math.max(result, s.length() - duplicate_free_index_so_far);
        
      
        return result;
    }

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }
}