/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while(A != null && B != null){
            if(A.val <= B.val){
                head.next = A;
                A = A.next;
                head = head.next;
            }else{
                head.next = B;
                B = B.next;
                head = head.next;
            }
        }
        
        while(A != null){
            head.next = A;
            A = A.next;
            head = head.next;
        }
        
        while(B != null){
            head.next = B;
            B = B.next;
            head = head.next;
        }
        
        return temp.next;
        
        
    }
}
