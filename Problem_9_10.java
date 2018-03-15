import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/*
Problem Description:
Queue with max
*/


public class Problem_9_10{
    public static class QueueWithMax{
        public Queue<Integer> queue = new LinkedList<>();
        public Deque<Integer> candidateWithMaxEntries = new LinkedList<>();

        public  void enqueue(Integer x){
            queue.add(x);
            while(!candidateWithMaxEntries.isEmpty()){
                if(candidateWithMaxEntries.getLast().compareTo(x) >= 0){
                    break;
                }
                candidateWithMaxEntries.removeLast();
            }
            candidateWithMaxEntries.addLast(x);
        }

        public Integer dequeue(){
            if(!queue.isEmpty()){
                Integer x = queue.remove();
                if(x.equals(candidateWithMaxEntries.getFirst())){
                    candidateWithMaxEntries.removeFirst();

                }
                return x;
            }
            throw new NoSuchElementException("Called dequeue() on empty queue.");
            
        }

        public Integer max(){
            if(!candidateWithMaxEntries.isEmpty()){
                return candidateWithMaxEntries.getFirst();
            }
            throw new NoSuchElementException("Empty queue");
        }
    }

    public static void main(String[] args) {
        QueueWithMax queue = new QueueWithMax();
        queue.enqueue(10);
        queue.enqueue(20);
        System.out.println(queue.max());
        queue.dequeue();
        System.out.println(queue.max());
        queue.enqueue(40);
        System.out.println(queue.max());
        
    }
}