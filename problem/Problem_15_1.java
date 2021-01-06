package problem;/*
Problem Description:

Check if Binary Tree is BST
*/


public class Problem_15_1{
    public static class BSTNode{
        public Integer data;
        public Character name;
        public BSTNode left, right;

        public BSTNode(Integer data, Character name){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean isBinaryBST(BSTNode tree){
       return isBinaryBSTUtil(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isBinaryBSTUtil(BSTNode tree, Integer lowerBound, Integer upperBound){
        if(tree == null){
            return true;
        }
        else{
            if(Integer.compare(tree.data, lowerBound) < 0 || Integer.compare(tree.data, upperBound) > 0)
            return false;
        }
        return isBinaryBSTUtil(tree.left, lowerBound, tree.data) && isBinaryBSTUtil(tree.right, tree.data, upperBound);
    }

    public static void main(String[] args) {
        BSTNode a = new BSTNode(19, 'a');
        BSTNode b = new BSTNode(7, 'b');
        BSTNode c = new BSTNode(3, 'c');
        BSTNode d = new BSTNode(2, 'd');
        BSTNode e = new BSTNode(5, 'e');
        BSTNode f = new BSTNode(11, 'f');
        BSTNode g = new BSTNode(17, 'g');
        BSTNode h = new BSTNode(13, 'h');
        BSTNode i = new BSTNode(43, 'i');
        BSTNode j = new BSTNode(23, 'j');
        BSTNode k = new BSTNode(37, 'k');
        BSTNode l = new BSTNode(29, 'l');
        BSTNode m = new BSTNode(31, 'm');
        BSTNode n = new BSTNode(41, 'n');
        BSTNode o = new BSTNode(47, 'o');
        BSTNode p = new BSTNode(53, 'p');

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


        System.out.println(isBinaryBST(a));

    }
}