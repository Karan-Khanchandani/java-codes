/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        TreeNode last_pop = root;
        
        while(!st.isEmpty()){
            TreeNode t = st.peek();
            if(t.left != null && t.left != last_pop && t.right != last_pop){
                st.push(t.left);
            }else if(t.right != null && t.right != last_pop && (t.left == null || t.left == last_pop)){
                st.push(t.right);
            }else{
                st.pop();
                last_pop = t;
                result.add(t.val);
            }
        }
        
        return result;
    }
}
