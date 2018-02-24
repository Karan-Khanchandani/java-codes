/*
Problem Description:
check if tree is symetrical
*/

public class Problem_10_2{

    public static class BinaryNode{
        public int data;
        BinaryNode left, right;

        public BinaryNode(int data){
            this.data = data;
            this.left = null;
            this.right =null;
        }
    }

    public static boolean isSymmetricalHelper(BinaryNode a, BinaryNode b){
        if( a == null && b == null)
            return true;
        if(a == null || b == null)
            return false;
        if(a.data == b.data){
        boolean sym =  isSymmetricalHelper(a.left, b.right) && isSymmetricalHelper(a.right, b.left);
        return sym;
        }
        return false;
        
    }

    public static boolean isSymmetrical(BinaryNode tree){
        return isSymmetricalHelper(tree, tree);
    }

    public static void main(String[] args) {
        BinaryNode tree = new BinaryNode(5);
        tree.left = new BinaryNode(3);
        tree.right = new BinaryNode(3);
        tree.left.left = new BinaryNode(2);
        tree.left.right = new BinaryNode(4);
        tree.right.left = new BinaryNode(4);
        tree.right.right = new BinaryNode(2);

        System.out.println(isSymmetrical(tree));

    }
}