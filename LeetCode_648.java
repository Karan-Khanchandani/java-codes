class Solution {
    
    public static class TrieNode{
        public Map<Character, TrieNode> children;
        public boolean isWord;
        
        public TrieNode(){
            this.children = new HashMap<>();
            this.isWord = false;
        }
    }
    
    public static class Trie{
        public TrieNode root;
        
        public Trie(){
            this.root = new TrieNode();
        }
        
        public void insert(String word){
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
        
        public int search(String word){
            
            TrieNode iter = root;
            int i;
            for(i = 0; i < word.length(); i++){
                Character c = word.charAt(i);
                if(iter.isWord){
                    return i;
                }
                if(iter == null || !iter.children.containsKey(c)){
                    return -1;
                }
                iter = iter.children.get(c);
            }
            
            return iter.isWord ? i : -1;
        }
    }
    
    public String replaceWords(List<String> dict, String sentence) {
        Trie t = new Trie();
        
        //Create trie
        for(String s: dict){
            t.insert(s);
        }
        
        String[] words = sentence.split(" ");
        
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            int index = t.search(word); 
            if(index != -1){
                //found the index
                word = word.substring(0, index);
            }
            words[i] = word;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < words.length; i++){
            if(i == words.length - 1){
                sb.append(words[i]);
            }else{
                sb.append(words[i]);
                sb.append(" ");
            }
        }
        
        return sb.toString();
    }
    
    
}
