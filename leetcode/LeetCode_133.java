package leetcode;

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    
    HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        
        if(node == null) return null;
        if(map.containsKey(node.label)) return map.get(node.label);
        
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        map.put(node.label, root);
        for(UndirectedGraphNode neighbor: node.neighbors){
            UndirectedGraphNode n = cloneGraph(neighbor);
            root.neighbors.add(n);
        }
        return root;
    }
}
