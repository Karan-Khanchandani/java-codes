class Trie {

    /** Initialize your data structure here. */
    
    public static class TrieNode{
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord;
        
        public TrieNode(){
            for(int i = 0; i < 26; i++){
                this.children[i] = null;
            }
            this.isWord = false;
        }
    }
    
    public TrieNode root;
    public Trie() {     
            root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode iter = root;
        for(int i = 0; i < word.length(); i++){
            Character c = word.charAt(i);
            if(iter.children[(int)(c - 'a')] == null){
                iter.children[(int)(c - 'a')] = new TrieNode();
            }
            iter = iter.children[(int)(c - 'a')];
        }
        iter.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode iter = root;
        for(int i = 0; i < word.length(); i++){
            Character c = word.charAt(i);
            if(iter == null || iter.children[(int)(c - 'a')] == null){
               return false;
            }
            iter = iter.children[(int)(c - 'a')];
        }
        
        return iter.isWord;
    }
    
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode iter = root;
        for(int i = 0; i < prefix.length(); i++){
            Character c = prefix.charAt(i);
            if(iter == null || iter.children[(int)(c - 'a')] == null){
               return false;
            }
            iter = iter.children[(int)(c - 'a')];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
