package leetcode;

class MaxStack {

    /** initialize your data structure here. */
    TreeMap<Integer, List<Node>> map;
    DoublyLinkedList dll;
    public MaxStack() {
        dll = new DoublyLinkedList();
        map = new TreeMap<>();
    }
    
    public void push(int x) {
        if(!map.containsKey(x)){
            map.put(x, new LinkedList<>());
        }
        Node node = dll.push(x);
        map.get(x).add(node);
    }
    
    public int pop() {
        int key = dll.pop().data;
        List<Node> nodes = map.get(key);
        nodes.remove(nodes.size() - 1);
        if(nodes.isEmpty()){
            map.remove(key);
        }
        return key;
    }
    
    public int top() {
        Node n = dll.peek();
        return n.data;
    }
    
    public int peekMax() {
        return map.lastKey();
    }
    
    public int popMax() {
        int key = map.lastKey();
        List<Node> nodes = map.get(key);
        Node n = nodes.get(nodes.size() - 1);
        dll.remove(n);
        nodes.remove(nodes.size() - 1);
        if(nodes.isEmpty()){
            map.remove(key);
        }
        return key;
    }
    
    static class DoublyLinkedList{
        Node head, tail;
        public DoublyLinkedList(){
            head = new Node(0);
            tail = new Node(0);
            
            head.next = tail;
            tail.prev = head;
        }
        
        public Node push(int data){
            Node node = new Node(data);
            node.next = tail;
            node.prev = tail.prev;
            tail.prev.next = node;
            tail.prev = node;
            
            return node;
        }
        
        public Node pop(){
            Node ret = tail.prev;
            tail.prev = ret.prev;
            ret.prev.next = tail;
            return ret;
        }
        
        public void remove(Node n){
            Node prev = n.prev;
            Node next = n.next;
            prev.next = n.next;
            next.prev = n.prev;
        }
        
        public Node peek(){
            return tail.prev;
        }
    }
    
    static class Node{
        int data;
        Node prev, next;
        public Node(int d){
            data = d;
            prev = next = null;
        }
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
