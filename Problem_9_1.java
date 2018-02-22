import java.util.Deque;
import java.util.LinkedList;

/*
Problem Description:
Implement Max API in Stack
*/

public class Problem_9_1{

    public static class StackNode{
        Integer data;
        Integer max;

        public StackNode(int data, int max){
            this.data = data;
            this.max = max;
        }
    }

    public static class Stack{
        private Deque<StackNode> stack = new LinkedList<>();

        public boolean empty(){
            return stack.isEmpty();
        }

        public Integer max(){
            if (empty()){
                throw new IllegalStateException("max (): empty stack");
                }
                return stack.peek().max;
        }

        public Integer pop(){
            if(empty()){
                throw new IllegalStateException("pop (): empty stack");
            }
            return stack.removeFirst().data;
        }

        public void push(Integer x){
            stack.addFirst(new StackNode(x, Math.max(x, empty()? x: max())));
        }
        
    }

    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(4);
        st.push(8);
        st.push(7);
        st.push(3);

        System.out.println(st.max());

        st.pop();
        st.pop();
        st.pop();
        st.push(6);

        System.out.println(st.max());

    }
}