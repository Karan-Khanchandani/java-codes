package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class LeetCode_nary_lvl_order {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        
        List<List<Integer>> l_order = new ArrayList<>();
        Deque<Node> parentNodes = new LinkedList<>();
        
        
        if(root != null){
            parentNodes.add(root);
        }
        
        while(!parentNodes.isEmpty()){
                
                List<Integer> list = new ArrayList<>();
                Deque<Node> childrenNodes = new LinkedList<>();
                for(Node p : parentNodes){
                    
                    for(Node c: p.children){
                        if(c!= null){
                            childrenNodes.add(c);
                        }
                    }
                    list.add(p.val);
                }
                l_order.add(list);
                parentNodes = childrenNodes;
                
            }
        
        return l_order;
        }
    }
