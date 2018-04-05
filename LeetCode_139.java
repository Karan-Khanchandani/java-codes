class Solution {
    
    public static class Trie{
        public boolean isWord;
        public Map<Character, Trie> children;
        
        public Trie(){
            this.isWord = false;
            this.children = new HashMap<>();
        }
    }
    
    public void addWord(Trie t, String s){
        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if(!t.children.containsKey(c)){
                t.children.put(c, new Trie());
            }
            t = t.children.get(c);
        }
        t.isWord = true;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie t = new Trie(), curr;
        for(String str: wordDict){
            addWord(t, str);
        }
        
        boolean[] f = new boolean[s.length() + 1];
        
        f[s.length()] = true;
        
        for(int i = s.length() - 1; i >= 0; i--){
            curr = t;
            for(int j = i; curr != null && j < s.length(); j++){
                curr = curr.children.get(s.charAt(j));
                if(curr != null && curr.isWord && f[j + 1]){
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f[0];
        
        
    }
}
