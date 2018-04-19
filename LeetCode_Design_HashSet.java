class MyHashSet {

    /** Initialize your data structure here. */
    public static boolean bucket[][];
    public MyHashSet() {
        bucket = new boolean[1001][];
        for(int i = 0; i < 1001; i++){
            bucket[i] = new boolean[1001];
        }
    }
    
    public void add(int key) {
        bucket[key/1001][key%1001] = true;
    }
    
    public void remove(int key) {
        bucket[key/1001][key%1001] = false;
    }
    
    /** Returns true if this set did not already contain the specified element */
    public boolean contains(int key) {
        return bucket[key/1001][key%1001];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
