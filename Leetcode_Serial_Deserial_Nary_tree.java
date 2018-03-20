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
class Codec {

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        
        if(root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        //sb.append("[ ");
        serialize_helper(root, sb);
        //sb.append("]");
        return sb.toString();
    }
    
    public StringBuilder serialize_helper(Node root, StringBuilder sb){
        if(root == null){
            return sb;
        }
       
        sb.append(Integer.toString(root.val));
        sb.append(" ");
        
        if(root.children.size() > 0){
            sb.append("[ ");
            for(Node c : root.children){
                sb.append(serialize_helper(c, new StringBuilder()));
            }
            sb.append("] ");
        }
        
        return sb;
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data.equals("")){
            return null;
        }
        
        String ss = data.trim();
       String[] strings = ss.split(" ");
       Stack<Node> node_st = new Stack<>();
        Stack<String> string_st = new Stack<>();
        
       for(int i = 0; i < strings.length; i++){
           String s = strings[i];
           if(s.equals("[")){
               string_st.push(s);
           }else if(s.equals("]")){
               List<Node> childrens = new ArrayList<>();
               while(!string_st.peek().equals("[")){
                   childrens.add(node_st.pop());
                   string_st.pop();
               }
               Collections.reverse(childrens);
               node_st.peek().children = childrens;
               string_st.pop();
               
           }else{
               if(!s.equals("")){
                   Node n = new Node(Integer.parseInt(s));
                   n.children = new ArrayList<Node>();
              node_st.push(n);
               string_st.push("$");
               }
           }
       }
        
        return node_st.peek();
    }
}
    
   

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
