package interviewbit;

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    
    static class Pair<TreeNode, Integer>{
        TreeNode key;
        int value;
        public Pair(TreeNode k, int v){
            this.key = k;
            this.value = v;
        }
        public TreeNode getKey(){return key;}
        public int getValue(){return value;}
    }
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(A == null) return res;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<Pair<TreeNode, Integer>>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int hd = 0;
        q.add(new Pair(A, hd));
        
        while(!q.isEmpty()){
            Pair<TreeNode, Integer> top = q.remove();
            hd = top.getValue();
            TreeNode n = top.getKey();
            if(!map.containsKey(hd)){
                map.put(hd, new ArrayList<>());
            }
            map.get(hd).add(n.val);
            if(n.left != null) q.add(new Pair(n.left, hd - 1));
            if(n.right != null) q.add(new Pair(n.right, hd + 1));
            
        }
        
        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        for(int key : keys){
            res.add(map.get(key));
        }
        return res;
    }
}
