package problem;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Queue;

/*
Problem Description:
Sliding window
*/

public class Problem_25_12 {
    public static class TrafficElement implements Comparable<TrafficElement> {
        public int time;
        public double volume;

        public TrafficElement(int time, double volume) {
            this.time = time;
            this.volume = volume;
        }

        @Override
        public int compareTo(TrafficElement o) {
            int volumecmp = Double.compare(volume, o.volume);
            return volumecmp != 0 ? volumecmp : time - o.time;
        }

        @Override
        public boolean equals(Object o){
            if(this == o){
                return true;
            }

            if(o == null || this.getClass() != o.getClass()){
                return false;
            }

            return (compareTo((TrafficElement)o) == 0);
        }

        @Override
        public int hashCode(){
            return Objects.hash(time, volume);
        }
    }

    public static class QueueWithMax<TrafficElement>{
        public Queue<TrafficElement> queue = new LinkedList<TrafficElement>();
        public Deque<TrafficElement> candidateWithMaxEntries = new LinkedList<TrafficElement>();

        public  void enqueue(TrafficElement x){
            queue.add(x);
            while(!candidateWithMaxEntries.isEmpty()){
                if((candidateWithMaxEntries.getLast()).compareTo(x) >= 0){
                    break;
                }
                candidateWithMaxEntries.removeLast();
            }
            candidateWithMaxEntries.addLast(x);
        }

        public TrafficElement dequeue(){
            if(!queue.isEmpty()){
                TrafficElement x = queue.remove();
                if(x.equals(candidateWithMaxEntries.getFirst())){
                    candidateWithMaxEntries.removeFirst();

                }
                return x;
            }
            throw new NoSuchElementException("Called dequeue() on empty queue.");
            
        }

        public TrafficElement max(){
            if(!candidateWithMaxEntries.isEmpty()){
                return candidateWithMaxEntries.getFirst();
            }
            throw new NoSuchElementException("Empty queue");
        }
    }

    public static List<TrafficElement> computeTrafficVolumes(List<TrafficElement> A , int W){
        QueueWithMax<TrafficElement> slidingWindow = new QueueWithMax<TrafficElement>();

        List<TrafficElement> results = new ArrayList<>();
        for(TrafficElement t : A){
            slidingWindow.enqueue(t);

            while(t.time - slidingWindow.head().time > W){
                slidingWindow.dequeue();
            }

            results.add(new TrafficElement(t.time, slidingWindow.max().volume));
        }
        return results;
    }

    public static void printList(List<TrafficElement> list){
        for(TrafficElement t: list){
            System.out.println(t.time + " " + t.volume);
        }
    }
    public static void main(String[] args) {
        List<TrafficElement> A =new ArrayList<>();
        A.add(new TrafficElement(0, 1.3));
        A.add(new TrafficElement(1, 0));
        A.add(new TrafficElement(2, 2.5));
        A.add(new TrafficElement(3, 3.7));
        A.add(new TrafficElement(4, 0));
        A.add(new TrafficElement(5, 3.7));

        List<TrafficElement> results = computeTrafficVolumes(A, 2);

        printList(results);
    }
}