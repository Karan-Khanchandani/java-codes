import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Reconstruct binary tree from inorder and preorder traversal
*/

public class Problem_10_12 {

    public static class BinaryNode {
        int data;
        char name;
        BinaryNode left, right;

        public BinaryNode(char name) {
            this.name = name;
            this.left = null;
            this.right = null;
        }
    }

    public static BinaryNode reconstructTree(List<Character> inorder, List<Character> preorder) {
        return reconstructTreeHelper(inorder, preorder, 0, inorder.size(), 0, preorder.size());
    }

    public static BinaryNode reconstructTreeHelper(List<Character> inorder, List<Character> preorder, int inorderStart,
            int inorderEnd, int preorderStart, int preorderEnd) {
        if (inorderStart >= inorderEnd || preorderStart >= preorderEnd)
            return null;

        // if()

        BinaryNode temp = new BinaryNode(preorder.get(preorderStart));
        int inorderRootIndex = inorder.indexOf(preorder.get(preorderStart));
        int leftSubtreeSize = inorderRootIndex - inorderStart;
        temp.left = reconstructTreeHelper(inorder, preorder, inorderStart, inorderRootIndex, preorderStart + 1,
                preorderStart + 1 + leftSubtreeSize);
        temp.right = reconstructTreeHelper(inorder, preorder, inorderRootIndex+1, inorderEnd,
                preorderStart + 1 + leftSubtreeSize, preorderEnd);

        return temp;
    }

    public static List<BinaryNode> inorder(BinaryNode tree, List<BinaryNode> inorderList) {
        if (tree == null)
            return null;

        inorder(tree.left, inorderList);
        inorderList.add(tree);
        inorder(tree.right, inorderList);

        return inorderList;
    }

    public static List<BinaryNode> preorder(BinaryNode tree, List<BinaryNode> preorderList) {
        if (tree == null)
            return null;
        preorderList.add(tree);
        preorder(tree.left, preorderList);
        preorder(tree.right, preorderList);

        return preorderList;
    }

    public static void printList(List<BinaryNode> list) {
        for (BinaryNode b : list) {
            System.out.print(b.name + " -> ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Character> inorderList = new LinkedList<>(
                Arrays.asList('d', 'c', 'e', 'b', 'f', 'h', 'g', 'a', 'j', 'l', 'm', 'k', 'n', 'i', 'o', 'p'));
        List<Character> preorderList = new LinkedList<>(
                Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p'));

        BinaryNode tree = reconstructTree(inorderList, preorderList);

        List<BinaryNode> inorder = new LinkedList<>();
        inorder = inorder(tree, inorder);

        printList(inorder);

    }
}