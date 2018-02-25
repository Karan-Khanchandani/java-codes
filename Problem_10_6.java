import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/*
Find root to leaf paths with specific sum
*/

public class Problem_10_6 {

    public static class BinaryNode {
        public int data;
        public char name;
        public BinaryNode left, right;

        public BinaryNode(int data, char name) {
            this.data = data;
            this.name = name;
            this.left = null;
            this.right = null;
        }
    }

    public static void hasPathHelper(BinaryNode tree, int partialSum, int targetSum, List<BinaryNode> partialList, List<List<BinaryNode>> paths) {
        if (tree == null) {
            return;
        }
        partialSum += tree.data;

        partialList.add(tree);

        if (tree.left == null && tree.right == null) {
            if (partialSum == targetSum) {
                paths.add(partialList);
            } else {
                return;
            }
        } else {
            List<BinaryNode> partialListLeft = new ArrayList<>(partialList);
            List<BinaryNode> partialListRight = new ArrayList<>(partialList);
            hasPathHelper(tree.left, partialSum, targetSum, partialListLeft, paths);
            hasPathHelper(tree.right, partialSum, targetSum, partialListRight,paths);
        }

    }

    public static List<List<BinaryNode>> hasPath(BinaryNode tree, int targetSum) {
        List<List<BinaryNode>> paths = new ArrayList<>();
        List<BinaryNode> partialList = new LinkedList<>();

        hasPathHelper(tree, 0, targetSum, partialList, paths);

        return paths.isEmpty() ? null : paths;
    }

    public static void printList(List<BinaryNode> list) {
        for (BinaryNode b : list) {
            System.out.print(b.name + " -> ");
        }

    }

    public static void print(List<List<BinaryNode>> paths) {
        for (int i = 0; i < paths.size(); i++) {
            printList(paths.get(i));
            System.out.println();
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

        List<List<BinaryNode>> paths = hasPath(a, 619);

        print(paths);
    }
}