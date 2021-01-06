package leetcode;

class MapSum {

    /** Initialize your data structure here. */
    
    public static class TrieNode{
        public Map<Character, TrieNode> children;
        public boolean isWord;
        public int count;
        
        public TrieNode(int count){
            this.isWord = false;
            this.children = new HashMap<>();
            this.count = count;
        }
    }
    
    public TrieNode root;
    public MapSum() {
        root = new TrieNode(0);
    }
    
    public void insert(String key, int val) {
        TrieNode iter = root;
        for(int i = 0; i < key.length(); i++){
            Character c = key.charAt(i);
            if(!iter.children.containsKey(c)){
                iter.children.put(c, new TrieNode(0));
            }
                iter = iter.children.get(c);
        }
        iter.isWord = true;
        iter.count = val;
    }
    
    public int sum(String prefix) {
        TrieNode iter = root;
        int count = 0;
        for(int i = 0; i < prefix.length();i++){
            Character c = prefix.charAt(i);
            if(iter == null || !iter.children.containsKey(c)){
                return 0;
            }
            iter = iter.children.get(c);
        }
           
        count = get_Child_Sum(iter, count);
        return count;
    }
    
    public int get_Child_Sum(TrieNode root, int count){
        if(root == null){
            return 0;
        }
        
        if(root.isWord){
            count = root.count;    
        }else{
            count = 0;
        }
        
        for(Map.Entry<Character, TrieNode> entry : root.children.entrySet()){
            
            count += get_Child_Sum(entry.getValue(), count);
        }
        
        return count;
        
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
