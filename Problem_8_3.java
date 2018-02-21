/**
Problem Description:
Detect cycle in linked list
 */

 public class Problem_8_3{
    public static class ListNode<T>{
        public T data;
        public ListNode<T> next;
    }

    public static ListNode<Integer> search(ListNode<Integer> head, int key){
        while(head != null && head.data != key){
            head = head.next;
        }

        return head;
    }

    public static void insertAfter(ListNode<Integer> list, int data){
        ListNode<Integer> newNode = new ListNode<>();
        newNode.data = data;
        newNode.next = list.next;
        list.next = newNode;

    }

    public static void delete(ListNode<Integer> aNode){
        aNode.next = aNode.next.next;
    }

    public static void printList(ListNode<Integer> list){
        while(list != null){
            System.out.print(list.data);
            System.out.print(" -> ");
            list = list.next;
        }
        System.out.println();
    }

    public static boolean isListCycle(ListNode<Integer> list){
        ListNode<Integer> fast = list;
        ListNode<Integer> slow = list;


        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }

        return false;
    }

     public static void main(String[] args) {
         ListNode<Integer> list = new ListNode<>();
         list.data = -1;
         list.next = null;

         insertAfter(list, 4);
         insertAfter(list, 2);
         insertAfter(list, 55);
         insertAfter(list, 412);
         insertAfter(list, 8);
         insertAfter(list, 9);
         insertAfter(list, 43);
         insertAfter(list, 64);
         insertAfter(list, 48);
         insertAfter(list, 41);

        list.next.next.next.next.next = list.next.next;

        System.out.println(isListCycle(list));
     }
 }