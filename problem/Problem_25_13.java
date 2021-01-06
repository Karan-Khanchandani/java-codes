package problem;

import java.util.Deque;
import java.util.LinkedList;

/*
Problem Description:
Implement post order traversal without recursion
*/


public  class Problem_25_13{

    public static class BinaryNode{
        public int data;
        public char name;
        public BinaryNode left, right;

        public BinaryNode(int data, char name){
            this.data = data;
            this.name = name;
        }
    }

    public static void preOrderTraversal(BinaryNode tree){

        if(tree == null){
            return;
        }
        Deque<BinaryNode> stack = new LinkedList<>();
        BinaryNode prev = null;
        stack.addFirst(tree);

        while(!stack.isEmpty()){
            BinaryNode curr = stack.peekFirst();

            if(prev == null || prev.left == curr || prev.right == curr){

                if(curr.left != null){
                    stack.addFirst(curr.left);
                }
                else if(curr.right != null){
                    stack.addFirst(curr.right);
                }
               else{
                   System.out.print(curr.name + " ");
                    stack.removeFirst();
               }


            }else if(curr.left == prev){
                //come on top from left
                if(curr.right != null){
                    stack.addFirst(curr.right);
                }else{
                    System.out.print(curr.name + " ");
                    stack.removeFirst();
                }
            }else{
                //done from right
                System.out.print(curr.name + " ");
                stack.removeFirst();
            }
            prev = curr;
        }
    }


    public static void main(String[] args) {
        BinaryNode a = new BinaryNode(314, 'a');
        BinaryNode b = new BinaryNode(6, 'b');
        BinaryNode c = new BinaryNode(271, 'c');
        BinaryNode d = new BinaryNode(28, 'd');
        BinaryNode e = new BinaryNode(0, 'e');
        BinaryNode f = new BinaryNode(561, 'f');
        BinaryNode g = new BinaryNode(3, 'g');
        BinaryNode h = new BinaryNode(17, 'h');
        BinaryNode i = new BinaryNode(6, 'i');
        BinaryNode j = new BinaryNode(2, 'j');
        BinaryNode k = new BinaryNode(1, 'k');
        BinaryNode l = new BinaryNode(401, 'l');
        BinaryNode m = new BinaryNode(641, 'm');
        BinaryNode n = new BinaryNode(257, 'n');
        BinaryNode o = new BinaryNode(271, 'o');
        BinaryNode p = new BinaryNode(28, 'p');

        a.left = b;
        a.right = i;
        b.left = c;
        b.right = f;
        i.left = j;
        i.right = o;
        c.left = d;
        c.right = e;
        j.right = k;
        o.right = p;
        f.right = g;
        g.left = h;
        k.left = l;
        k.right = n;
        l.right = m;

        preOrderTraversal(a);
    }
}