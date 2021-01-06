package problem;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class Problem_11_7{

    private static class ValueWithRank{
        private Integer value;
        private Integer rank;

        public ValueWithRank(Integer value, Integer rank){
            this.value = value;
            this.rank = rank;
        }
    }

    

    private static class Compare implements Comparator<ValueWithRank>{
        @Override
        public int compare(ValueWithRank o1, ValueWithRank o2){
            return Integer.compare(o2.rank, o1.rank);
        }

        public static final Compare COMPARE_VALUEWITHRANK = new Compare();
    }



    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public static class Stack{
        private static  int timeStamp = 0;

        private PriorityQueue<ValueWithRank> maxHeap = new PriorityQueue<>(
            DEFAULT_INITIAL_CAPACITY, Compare.COMPARE_VALUEWITHRANK
        );

        public void push(Integer x){
            maxHeap.add( new ValueWithRank(x, timeStamp++));
        }

        public int pop() throws NoSuchElementException{
            return maxHeap.remove().value;
        }

        public int peek(){
            return maxHeap.peek().value;
        }



    }

    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(100);
        st.push(300);
        st.push(200);
        

        System.out.println(st.peek());

        st.pop();

        System.out.println(st.peek());

    }
}