import java.util.HashMap;
import java.util.Map;

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class LeetCode_138 {
    public static RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode iter = head;
        
        Map<RandomListNode, RandomListNode> hm = new HashMap<>();
        
        while(iter != null){
            RandomListNode r = new RandomListNode(iter.label);
            hm.put(iter, r);
            iter = iter.next;
        }
        
        //first fix the next pointers
        
        for(Map.Entry<RandomListNode, RandomListNode> entry : hm.entrySet()){
            RandomListNode r1 = entry.getKey();
            RandomListNode r2 = entry.getValue();   
            RandomListNode r1_next = r1.next;
            r2.next = hm.get(r1_next);       
        }
        
        //fix random pointers
        for(Map.Entry<RandomListNode, RandomListNode> entry : hm.entrySet()){
            RandomListNode r1 = entry.getKey();
            RandomListNode r2 = entry.getValue();   
            RandomListNode r1_next = r1.random;
            r2.random = hm.get(r1_next);       
        }
        
        return hm.get(head);
    }
    public static void main(String[] args) {
        
    }
}