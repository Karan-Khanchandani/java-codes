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
    
    static ListNode merge(ListNode l1, ListNode l2){
        ListNode temp = new ListNode(-1);
        ListNode p = temp;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        
        if(l1 != null) p.next = l1;
        if(l2 != null) p.next = l2;
        
        return temp.next;
    }
    public ListNode sortList(ListNode A) {
        if(A == null || A.next == null) return A;
        
        ListNode prev = null, slow = A, fast = A;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        
        ListNode l1 = sortList(A);
        ListNode l2 = sortList(slow);
        
        return merge(l1, l2);
    }
}
