package leetcode;

class Solution {
    public int numJewelsInStones(String J, String S) {
        HashMap<Character, Boolean> jewels = new HashMap<>();
        
        for(int i = 0; i < J.length(); i++){
            Character c = J.charAt(i);
            if(!jewels.containsKey(c)){
                jewels.put(c, true);
            }
        }
        
        int count = 0;
        for(int j = 0; j < S.length(); j++){
            Character c = S.charAt(j);
            if(jewels.containsKey(c)){
                count++;
            }
        }
        return count;
    }
}
