package problem;/*
Problem Description:
Find the kth node in inorder traversal
*/

public class Problem_10_9 {
    public static class BinaryNode {
        public int data;
        public char name;
        public int size;
        BinaryNode left, right;

        public BinaryNode(int data, char name, int size) {
            this.data = data;
            this.size = size;
            this.name = name;
        }
    }

    public static BinaryNode kthNode(BinaryNode tree, int k){
        if(tree == null)
            return null;
        BinaryNode iter = tree;
        while(iter != null){
            int leftSize = iter.left != null? iter.left.size:0;
            if(k < leftSize + 1){
                iter = iter.left;
            }else if(k == leftSize  + 1){
                return iter;
            }else{
                k -= (leftSize +1 );
                iter = iter.right;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        BinaryNode a = new BinaryNode(314, 'a', 16);
        BinaryNode b = new BinaryNode(6, 'b', 7);
        BinaryNode c = new BinaryNode(271, 'c', 3);
        BinaryNode d = new BinaryNode(28, 'd', 1);
        BinaryNode e = new BinaryNode(0, 'e', 1);
        BinaryNode f = new BinaryNode(561, 'f', 3);
        BinaryNode g = new BinaryNode(3, 'g', 2);
        BinaryNode h = new BinaryNode(17, 'h', 1);
        BinaryNode i = new BinaryNode(6, 'i', 8);
        BinaryNode j = new BinaryNode(2, 'j', 5);
        BinaryNode k = new BinaryNode(1, 'k', 4);
        BinaryNode l = new BinaryNode(401, 'l', 2);
        BinaryNode m = new BinaryNode(641, 'm', 1);
        BinaryNode n = new BinaryNode(257, 'n', 1);
        BinaryNode o = new BinaryNode(271, 'o', 2);
        BinaryNode p = new BinaryNode(28, 'p', 1);

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

        BinaryNode kthNode = kthNode(a, 3);
        System.out.println(kthNode.name);

         kthNode = kthNode(a, 1);
        System.out.println(kthNode.name);

         kthNode = kthNode(a, 15);
        System.out.println(kthNode.name);

         kthNode = kthNode(a, 8);
        System.out.println(kthNode.name);
    }
}