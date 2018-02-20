/*
Problem Description:

Merge two sorted linked list
*/

public class Problem_8_1{

    public static class ListNode<Integer>{
        public Integer data;
        public ListNode<Integer> next;
    }

    public static ListNode<Integer> search(ListNode<Integer> head, int key){
        while(head != null && head.data != key){
            head = head.next;
        }

        return head;
    }

    public static void insertAfter(ListNode<Integer> head, int data){
        ListNode<Integer> newNode = new ListNode<Integer>();
        newNode.data = data;
        newNode.next = head.next;
        head.next = newNode;
    }

    public static void deleteNode(ListNode<Integer> aNode){
        aNode.next = aNode.next.next;
    }

    public static void printList(ListNode<Integer> head){
        while(head != null){
            System.out.print(head.data);
            System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode<Integer> mergeLists(ListNode<Integer> list1, ListNode<Integer> list2){

        ListNode<Integer> dummyNode = new  ListNode<Integer>();
        dummyNode.data = -1;
        dummyNode.next = null;
        ListNode<Integer> currentNode = dummyNode;

        while(list1 != null && list2 != null){
            if(list1.data <= list2.data){
                currentNode.next = list1;
                list1 = list1.next; 
            }else{
                currentNode.next = list2;
                list2 = list2.next; 
            }
            currentNode = currentNode.next;
        }

        currentNode.next = (list1 != null) ? list1 : list2;
        return dummyNode.next;
    }


    public static void main(String[] args) {
        ListNode<Integer> list1 = new ListNode<>();
        list1.data = -1;
        list1.next = null;

        ListNode<Integer> list2 = new ListNode<>();
        list2.data = -1;
        list2.next = null;

        insertAfter(list1, 1);
        insertAfter(list1.next, 3);
        insertAfter(list1.next.next, 4);
        insertAfter(list1.next.next.next, 7);
        insertAfter(list1.next.next.next.next, 8);
        insertAfter(list1.next.next.next.next.next, 11);

        insertAfter(list2, 0);
        insertAfter(list2.next, 1);
        insertAfter(list2.next.next, 2);
        insertAfter(list2.next.next.next, 5);

        printList(list1);
        printList(list2);

        list1 = mergeLists(list1.next,list2.next);

        printList(list1);
    }
}