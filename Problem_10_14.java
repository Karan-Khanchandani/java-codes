import java.util.LinkedList;
import java.util.List;
/*
Make a list of leaves of binary tree
*/


public class Problem_10_14{
    public static class BinaryNode{
        public int data;
        public char name;
        public BinaryNode left, right;

        public BinaryNode(int data, char name){
            this.data = data;
            this.name = name;
            this.left =null;
            this.right = null;
        }
    }

    public static void addLeavesLeftToRightHelper(BinaryNode tree ,List<BinaryNode> leaves){
        if(tree != null){
            if(tree.left == null && tree.right == null){
                leaves.add(tree);
            }
            addLeavesLeftToRightHelper(tree.left, leaves);
            addLeavesLeftToRightHelper(tree.right, leaves);
        }
    }

    public static List<BinaryNode> addLeavesLeftToRight(BinaryNode tree){
        List<BinaryNode> leaves = new LinkedList<>();
        addLeavesLeftToRightHelper (tree, leaves);
                return leaves;
    }

    public static void printList(List<BinaryNode> list){
        for(BinaryNode b: list){
            System.out.print(b.name + " -> ");
        }
        System.out.println();
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

        List<BinaryNode> leaves = addLeavesLeftToRight(a);

        printList(leaves);
    }
}