package problem;

import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;

/**
 Problem Description:

 Implement circular queue
 */

 public class Problem_9_8{

    public static class CircularQueue{

        private int head = 0, tail = 0, numOfEntries = 0;
        final private int SCALE_FACTOR = 2;
        private Integer[] entries;

        public CircularQueue(int capacity){
            this.entries = new Integer[capacity];
        }

        public void enqueue(Integer x){
            //add at rear
            if(numOfEntries == entries.length){
                Collections.rotate(Arrays.asList(entries), -head);
                head =  0;
                tail = numOfEntries;
                entries = Arrays.copyOf(entries, entries.length*SCALE_FACTOR);
            }
            entries[tail] = x;
            tail = (tail + 1)%entries.length;
            numOfEntries++;
        }

        public Integer dequeue(){
            //delete from front
            if(numOfEntries != 0){
                Integer ret = entries[head];
                head = (head + 1)%entries.length;
                numOfEntries--;
                return ret;
            }

            throw new NoSuchElementException("dequeue() called on empty queue");
        }

        public int size(){
            return numOfEntries;
        }

    }
     public static void main(String[] args) {
         CircularQueue cq = new CircularQueue(5);

         cq.enqueue(2);
         cq.enqueue(3);
         cq.enqueue(5);
         cq.enqueue(3);
         cq.enqueue(24);

         System.out.println(cq.size());

         cq.enqueue(56);
         System.out.println(cq.size());
         Integer x = cq.dequeue();
         System.out.println(x);

         System.out.println(cq.size());
     }
 }