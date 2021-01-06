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
    public ListNode deleteDuplicates(ListNode A) {
        ListNode temp = new ListNode(-1);
        ListNode ret = temp;
        ListNode curr = A;
        while(curr!=null){
            int count = 0;
            ListNode iter = curr;
            while(iter != null && curr.val == iter.val){
                count++;
                iter = iter.next;
            }
            if(count == 1){
                temp.next = curr;
                temp = temp.next;
            }
            curr = iter;
        }
        temp.next = null;
        return ret.next;
    }
}
