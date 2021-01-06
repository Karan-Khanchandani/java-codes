package leetcode;

class MyHashMap {

    /** Initialize your data structure here. */
    private static int map[][];
    public MyHashMap() {
        map = new int[1001][];
        for(int i = 0; i < 1001; i++){
            map[i] = new int[1001];
            Arrays.fill(map[i], -1);
        }
    }
    
    /** value will always be positive. */
    public void put(int key, int value) {
        map[key/1001][key%1001] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return map[key/1001][key%1001];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        map[key/1001][key%1001] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
