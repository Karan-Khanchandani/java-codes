package problem;

/**
 Problem Description: Implement odd-even merge in list
 */

public class Problem_8_10 {

    public static class ListNode<T> {
        public T data;
        ListNode<T> next;
    }

    public static ListNode<Integer> mergeOddEven(ListNode<Integer> list){

        ListNode<Integer> lastEven = null, lastOdd = null, lastEvenStart = null, lastOddStart = null;

        while(list != null){
            if(list.data%2 == 0){
                //even
                if(lastEven == null){
                    lastEvenStart = list;
                    lastEven = list;
                }else{
                    lastEven.next = list;
                    lastEven = list;
                }
            }else{
                //odd
                if(lastOdd == null){
                    lastOdd = list;
                    lastOddStart = list;
                }else{
                    lastOdd.next = list;
                    lastOdd = list;
                }
            }
            list = list.next;
        }
        if(lastEven != null)
        lastEven.next = lastOddStart;
        return lastEvenStart != null ? lastEvenStart:lastOddStart;
    }

    public static ListNode<Integer> insert(ListNode<Integer> list, int data) {
        ListNode<Integer> head = list;
        if (list == null) {

            list = new ListNode<Integer>();
            list.data = data;
            list.next = null;
            return list;

        } else {

            while (list.next != null) {
                list = list.next;
            }
            ListNode<Integer> newNode = new ListNode<Integer>();
            newNode.data = data;
            list.next = newNode;
            newNode.next = null;
            return head;
        }
    }

    public static void printList(ListNode<Integer> list) {
        while (list != null) {
            System.out.print(list.data);
            if(list.next != null)
            System.out.print(" -> ");
            list = list.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode<Integer> list = null;

        //insert
        list = insert(list, 2);
        list = insert(list, 1);
        list = insert(list, 3);
        list = insert(list, 5);
        list = insert(list, 4);
        list = insert(list, 6);
        list = insert(list, 7);
        list = insert(list, 8);
       list = insert(list, 10);
        list = insert(list, 11);

        //printList(list);

        list = mergeOddEven(list);
        printList(list);

    }

}