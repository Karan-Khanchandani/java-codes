/*
Problem Description:
Find LCA of two nodes in Binary Tree
*/

public class Problem_10_3 {
    public static class BinaryNode {
        public char data;
        public BinaryNode left, right;

        public BinaryNode(char data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class BinaryNodeStatus {
        int numNodeStatus;
        BinaryNode ancestor;

        public BinaryNodeStatus(int numNodeStatus, BinaryNode ancestor) {
            this.numNodeStatus = numNodeStatus;
            this.ancestor = ancestor;
        }
    }

    public static BinaryNodeStatus LCAHelper(BinaryNode tree, BinaryNode a, BinaryNode b) {
        if (tree == null)
            return new BinaryNodeStatus(0, null);

        BinaryNodeStatus left = LCAHelper(tree.left, a, b);
        if (left.numNodeStatus == 2) {
            return left;
        }

        BinaryNodeStatus right = LCAHelper(tree.right, a, b);

        if (right.numNodeStatus == 2) {
            return right;
        }

        int numofNodes = left.numNodeStatus + right.numNodeStatus + (tree == a ? 1 : 0) + (tree == b ? 1 : 0);

        return new BinaryNodeStatus(numofNodes, (numofNodes == 2) ? tree : null);

    }

    public static BinaryNode LCA(BinaryNode tree, BinaryNode a, BinaryNode b) {
        return LCAHelper(tree, a, b).ancestor;
    }

    public static void main(String[] args) {
        BinaryNode a = new BinaryNode('a');
        BinaryNode b = new BinaryNode('b');
        BinaryNode c = new BinaryNode('c');
        BinaryNode d = new BinaryNode('d');
        BinaryNode e = new BinaryNode('e');
        BinaryNode f = new BinaryNode('f');
        BinaryNode g = new BinaryNode('g');
        BinaryNode h = new BinaryNode('h');
        BinaryNode i = new BinaryNode('i');

        a.left = b;
        a.right = e;
        b.left = c;
        b.right = f;
        c.left = d;
        c.right = g;
        e.left = i;
        e.right =h;

        System.out.println(LCA(a, g, f).data);
        System.out.println(LCA(a, a, d).data);

    }
}