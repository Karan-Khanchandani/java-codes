import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 Problem Description:
 Reconstruct BST from Preorder Traversal
 */

public class Problem_15_5 {

    private static Integer rootIdx;

    public static class BSTNode {
        public Integer data;
        public BSTNode left, right;

        public BSTNode(Integer data, BSTNode left, BSTNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static BSTNode reconstructBST(List<Integer> preorder) {
        rootIdx = 0;
        return reconstructBSTHelper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static BSTNode reconstructBSTHelper(List<Integer> preorder, Integer lowerBound, Integer upperBound) {
        if (rootIdx == preorder.size()) {
            return null;
        }
        Integer root = preorder.get(rootIdx);
        if (root < lowerBound || root > upperBound) {
            return null;
        }
        ++rootIdx;

        BSTNode leftSubtree = reconstructBSTHelper(preorder, lowerBound, root);
        BSTNode rightSubtree = reconstructBSTHelper(preorder, root, upperBound);
        return new BSTNode(root, leftSubtree, rightSubtree);
    }

    public static void printInorder(BSTNode tree) {
        if (tree != null) {
            printInorder(tree.left);
            System.out.print(tree.data + " ");
            printInorder(tree.right);
        }
    }

    public static void main(String[] args) {

        List<Integer> preorder = new ArrayList<Integer>();

        preorder.add(10);
        preorder.add(5);
        preorder.add(1);
        preorder.add(7);
        preorder.add(40);
        preorder.add(50);

        BSTNode bst = reconstructBST(preorder);

        printInorder(bst);
    }
}