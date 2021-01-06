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
    public ListNode insertionSortList(ListNode A) {
       if(A == null || A.next == null) return A;
       
       ListNode ret = null;
       while(A != null){
           ListNode curr = A;
           A = A.next;
           if(ret == null || curr.val < ret.val){
               curr.next = ret;
               ret = curr;
           }else{
               ListNode temp = ret;
               while(temp != null){
                   if(temp.next == null || curr.val < temp.next.val){
                       curr.next = temp.next;
                   temp.next = curr;
                    break; // done
                   }
                   temp = temp.next;
               }
           }
       }
        return ret;
    }
}
