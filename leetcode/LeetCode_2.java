package leetcode;/*
Problem Description:

Add two linked list numbers
*/

public class LeetCode_2 {

    public static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
        }
    }

    public static void printList(ListNode l){
        System.out.print("[ ");
        while(l != null){
            System.out.print(l.val + ", ");
            l = l.next;
        }
        System.out.print("]");
        System.out.println();
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carryIn = 0, carryOut = 0;

        ListNode result = null, head = null;

        while (l1 != null || l2 != null) {
            int sum = 0;

            if (l1 == null) {
                sum = l2.val + carryIn;
                l2 = l2.next;

            } else if (l2 == null) {
                sum = l1.val + carryIn;
                l1 = l1.next;
            } else {
                sum = l1.val + l2.val + carryIn;
                l1 = l1.next;
                l2 = l2.next;
            }

            if (sum >= 10) {
                carryOut = sum / 10;
                sum = sum % 10;
            } else {
                carryOut = 0;
            }

            if (result == null) {
                //New Node           
                result = new ListNode(sum);
                head = result;
                result.next = null;
            } else {
                result.next = new ListNode(sum);
                result = result.next;
            }
            carryIn = carryOut;

        }

        if (carryOut > 0) {
            result.next = new ListNode(carryOut);
            result = result.next;
        }

        result.next = null;

        return head;
    }

    public static void main(String[] args) {
       ListNode a = new ListNode(9);
       a.next = new ListNode(9);
       a.next.next = new ListNode(9);
       a.next.next.next = null; 
       
       ListNode b = new ListNode(9);
       b.next = new ListNode(9);
       b.next.next = null;
       
       ListNode c = addTwoNumbers(a, b);
       printList(c);
    }
}