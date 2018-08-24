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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        ArrayList<TreeNode> parent = new ArrayList<>();
        parent.add(root);
        
        while(!parent.isEmpty()){
            ArrayList<TreeNode> child = new ArrayList<>();
            TreeNode rightMost = parent.get(parent.size() - 1);
            res.add(rightMost.val);
            for(int i = 0; i < parent.size(); i++){
                TreeNode curr = parent.get(i);
                if(curr.left != null) child.add(curr.left);
                if(curr.right != null) child.add(curr.right);
            }
            parent = child;
        }
        
        return res;
    }
}
