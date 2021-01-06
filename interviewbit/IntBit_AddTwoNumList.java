package interviewbit;

public class IntBit_AddTwoNumList {
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        int carry = 0;
        ListNode res = new ListNode(-1);
        ListNode ret = res;
        while (A != null || B != null) {
            int sum = carry;
            if (A != null) sum += A.val;
            if (B != null) sum += B.val;
            carry = sum / 10;
            res.next = new ListNode(sum % 10);
            if (A != null) A = A.next;
            if (B != null) B = B.next;
            res = res.next;
        }
        if (carry > 0) res.next = new ListNode(carry);
        return ret.next;

    }

    private class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
