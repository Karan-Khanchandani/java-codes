package leetcode;/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Codec {

    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if(root != null){
            TreeNode bt_root = encode_Helper(root, new ArrayList<>(), root.children);
            return bt_root;
        }else{
            return null;
        }
        
    }
    
    public TreeNode encode_Helper(Node root, List<Node> siblings, List<Node> children){
        if(root == null){
            return null;
        }
        TreeNode bt_root = new TreeNode(root.val);
        if(siblings.size() > 0){
            Node c = siblings.remove(0);
            bt_root.left = encode_Helper(c, siblings, c.children);
        }else{
            bt_root.left = null;
        }
        
        if(children.size() > 0){
            Node f = children.remove(0);
            bt_root.right = encode_Helper(f, children, f.children);
        }else{
            bt_root.right = null;
        }
        return bt_root;
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if(root == null){
            return null;
        }
        Node nRoot = decode_Helper(root, root.right);
        return nRoot;
    }
    
    public Node decode_Helper(TreeNode root, TreeNode childrenPtr){
        if(root == null){
            return null;
        }
        
        Node nRoot = new Node(root.val);
        
        List<Node> children = new ArrayList<>();
        while(childrenPtr != null){
            children.add(decode_Helper(childrenPtr, childrenPtr.right));
            childrenPtr = childrenPtr.left;
        }
        nRoot.children = children;       
        return nRoot;
    }
    
    
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(root));
