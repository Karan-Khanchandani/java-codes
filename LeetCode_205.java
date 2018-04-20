class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        
        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Character> rMap = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                if(!rMap.containsKey(t.charAt(i))){
                    map.put(s.charAt(i), t.charAt(i));
                    rMap.put(t.charAt(i), s.charAt(i));
                }else{
                    if(rMap.get(t.charAt(i)) != s.charAt(i)){
                        return false;
                    }
                }
            }else{
                if(map.get(s.charAt(i)) != t.charAt(i)){
                    return false;
                }
            }
        } 
        return true;
    }
}
