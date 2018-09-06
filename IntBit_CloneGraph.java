/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    
    private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return node;
        return cloneGraphUtil(node);
    }
    
     public UndirectedGraphNode cloneGraphUtil(UndirectedGraphNode node) {
        if(node == null) return node;
        if(map.containsKey(node.label)) return map.get(node.label);
        
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        map.put(root.label, root);
        for(UndirectedGraphNode neighbor : node.neighbors){
            root.neighbors.add(cloneGraph(neighbor));
        }
        return root;
    }
}
