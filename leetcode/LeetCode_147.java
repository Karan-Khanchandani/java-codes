package leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
       ListNode dummy = new ListNode(0);
       ListNode prev = dummy;
        
        while(head != null){
            ListNode temp = head.next;
            
            if(prev.val >= head.val){
                prev = dummy;
            }
            
            while(prev.next != null && prev.next.val < head.val){
                prev = prev.next;
            }
            
            head.next = prev.next;
            prev.next = head;
            head = temp;
        }
        
        return dummy.next;
    }
}
