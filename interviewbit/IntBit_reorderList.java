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
    static ListNode reverse(ListNode A){
        if(A == null || A.next == null) return A;
        
        ListNode prev = null, curr = A;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        A = prev;
        return A;
        
    }
    public ListNode reorderList(ListNode A) {
        if(A == null || A.next == null) return A;
        
        ListNode slow = A, fast = A;
        ListNode prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        
        prev.next = null;
        ListNode firstList = A;
        ListNode secondList = slow;
        
        ListNode revSec = reverse(secondList);
        
        ListNode temp = new ListNode(-1);
        ListNode ret = temp;
        // while(firstList != null && revSec != null){
        //     ListNode fn = firstList.next;
        //     ListNode rn = revSec.next;
            
            
        //     revSec.next = fn;
        //     firstList.next = revSec;
            
        //     firstList = fn;
        //     revSec = rn;
        // }
        
        while(firstList != null && revSec != null){
            ListNode fn = firstList.next;
            ListNode rn = revSec.next;
            temp.next = firstList;
            temp = temp.next;
            temp.next = revSec;
            temp = temp.next;
            firstList = fn;
            revSec = rn;
        }
        
        while(firstList != null){
            temp.next = firstList;
            firstList = firstList.next;
            temp = temp.next;
        }
        
        while(revSec != null){
            temp.next = revSec;
            revSec = revSec.next;
            temp = temp.next;
        }
        temp.next = null;
        
        return ret.next;
        
    }
}
