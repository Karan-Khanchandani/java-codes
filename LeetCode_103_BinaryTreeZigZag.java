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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        ArrayList<TreeNode> parent = new ArrayList<>();
        parent.add(root);
        boolean isLeft = true;
        
        while(!parent.isEmpty()){
            ArrayList<TreeNode> child = new ArrayList<>();
            ArrayList<Integer> temp = new ArrayList<>();
            if(isLeft){
                //add parent
                for(int i = 0; i < parent.size(); i++){
                    TreeNode curr = parent.get(i);
                    temp.add(curr.val);
                    if(curr.left != null) child.add(curr.left);
                    if(curr.right != null) child.add(curr.right);
                }
                Collections.reverse(child);
            }else{
                 for(int i = 0; i < parent.size(); i++){
                    TreeNode curr = parent.get(i);
                    temp.add(curr.val);
                    if(curr.right != null) child.add(curr.right);
                    if(curr.left != null) child.add(curr.left);
                }
                Collections.reverse(child);
            }
            isLeft = !isLeft;
            res.add(temp);
            parent = child;
        }
        
        return res;
    }
}
