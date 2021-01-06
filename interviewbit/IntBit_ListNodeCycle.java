package interviewbit;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode a) {
        if(a == null) return a;
        if(a.next == null || a.next.next == null) return null;
        ListNode tor = a.next;
        ListNode hare = a.next.next;
        while(hare != null && hare.next != null && tor != null   && tor != hare){
            hare = hare.next.next;
            tor = tor.next;
        }
        
        if(hare == null || tor == null)return null;
        hare = a;
        while(tor!= null && hare!=null && tor != hare){
            hare = hare.next;
            tor= tor.next;
        }
        return tor;
    }
}
