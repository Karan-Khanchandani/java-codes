package interviewbit;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode next;
 * ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode A) {
        ListNode dummy = new ListNode(0);
        ListNode head = A;
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null && head.next != null) {
            ListNode sec = head.next;
            head.next = sec.next;
            sec.next = head;
            pre.next = sec;
            pre = head;
            head = head.next;
        }
        return dummy.next;
    }
}
