/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        
        RandomListNode iter = head;
        while(iter != null){
            map.put(iter, new RandomListNode(iter.label));
            iter = iter.next;
        }
        iter = head;
        while(iter != null){
            map.get(iter).next = map.get(iter.next);
            map.get(iter).random = map.get(iter.random);
            iter = iter.next;
        }
        
        return map.get(head);
        
    }
}
