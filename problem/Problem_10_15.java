package problem;

import java.util.LinkedList;
import java.util.List;

/*
Problem Description:
Print Exterior of tree
*/

public class Problem_10_15 {
    public static class BinaryNode {
        int data;
        char name;
        BinaryNode left, right;

        public BinaryNode(int data, char name) {
            this.data = data;
            this.name = name;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean isLeaf(BinaryNode tree) {
        return tree.left == null && tree.right == null;
    }

    public static List<BinaryNode> leftTreeLeavesBoundaries(BinaryNode tree, boolean isBoundary) {
        List<BinaryNode> result = new LinkedList<>();
        if (tree != null) {
            if (isBoundary || isLeaf(tree)) {
                result.add(tree);
            }
            result.addAll(leftTreeLeavesBoundaries(tree.left, isBoundary));
            result.addAll(leftTreeLeavesBoundaries(tree.right, isBoundary && tree.left == null));
        }

        return result;
    }

    public static List<BinaryNode> rightTreeLeavesBoundaries(BinaryNode tree, boolean isBoundary) {
        List<BinaryNode> result = new LinkedList<>();

        if (tree != null) {
            result.addAll(leftTreeLeavesBoundaries(tree.left, isBoundary && tree.right == null));
            result.addAll(leftTreeLeavesBoundaries(tree.right, isBoundary));
            if ( isLeaf(tree)|| isBoundary) {
                result.add(tree);
            }
        }

        return result;
    }

    public static List<BinaryNode> exterior(BinaryNode tree) {
        List<BinaryNode> exteriorList = new LinkedList<>();
        if (tree != null) {
            exteriorList.add(tree);
            exteriorList.addAll(leftTreeLeavesBoundaries(tree.left, true));
            exteriorList.addAll(rightTreeLeavesBoundaries(tree.right, true));
        }
        return exteriorList;
    }

    public static void printList(List<BinaryNode> list) {
        for (BinaryNode b : list) {
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

        List<BinaryNode> exteriorNodes = exterior(a);
        printList(exteriorNodes);
    }
}