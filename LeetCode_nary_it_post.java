/*
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
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        
        if(root == null){
            return result;
        }
        
        Stack<Node> st = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        st.push(root);
        while(!st.isEmpty()){
           Node n = st.peek();
            if(n.children.size() == 0 || set.contains(n)){
                result.add(st.pop().val);
            }else{
                Collections.reverse(n.children);
                for(Node c : n.children){
                    if(c != null){
                        st.push(c);
                    }
                }
                set.add(n);
            }
        }
        return result;
    }
}
