package leetcode;

class WordDictionary {
    
    public TrieNode root;
    
    
    public static class TrieNode{
        public Map<Character, TrieNode> children;
        public boolean isWord;
        
        public TrieNode(){
            this.children = new HashMap<>();
            this.isWord = false;
        }
    }

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode iter = root;
        for(int i = 0; i < word.length(); i++){
            Character c = word.charAt(i);
            if(!iter.children.containsKey(c)){
                iter.children.put(c, new TrieNode());
            }
            
            iter = iter.children.get(c);
        }
        iter.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode iter = root;
        boolean isPresent = search_helper(iter, 0, word);
        return isPresent;
    }
    
    public boolean search_helper(TrieNode iter, int index, String word){
        if(iter == null){
            return false;
        }

        if(index == word.length()){
            return iter.isWord;
        }
        
        Character c = word.charAt(index);
        if(c == '.'){
           for(Map.Entry<Character, TrieNode> entry: iter.children.entrySet()){
               if(search_helper(entry.getValue(), index + 1, word)){
                   return true;
               }        
           }
        }else{
            if(iter.children.containsKey(c)){
                return search_helper(iter.children.get(c), index + 1, word);
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
