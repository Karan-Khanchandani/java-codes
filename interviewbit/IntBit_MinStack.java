package interviewbit;

class Solution {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int x) {
        st.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            if (minStack.peek() >= x) {
                minStack.push(x);
            }
        }
    }

    public void pop() {

        if (!st.isEmpty()) {
            int top = st.peek();
            st.pop();
            if (minStack.peek() == top) minStack.pop();

        }
    }

    public int top() {
        if (!st.isEmpty()) return st.peek();
        return -1;
    }

    public int getMin() {
        if (!minStack.isEmpty()) return minStack.peek();
        return -1;
    }
}
