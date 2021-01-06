package problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
Find median of stream of numbers
Here we are using List of numbers just for simulation
*/

public class Problem_11_5{

    private static int DEFAULT_CAPACITY = 16;

    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(DEFAULT_CAPACITY, Collections.reverseOrder());

    public static double median(List<Integer> list, int counter){

        if(counter == 0){
            //first element
            minHeap.add(list.get(counter));
        }else{
            int x = list.get(counter);
            if(x >= minHeap.peek()){
                minHeap.add(x);
            }else{
                maxHeap.add(x);
            }
        }

        //adjust minheap and maxheap

        if(minHeap.size() > maxHeap.size() +1 ){
            maxHeap.add(minHeap.remove());
        }
        if(maxHeap.size() > minHeap.size()){
            minHeap.add(maxHeap.remove());
        }

        return (minHeap.size() == maxHeap.size() ? 0.5*(minHeap.peek() + maxHeap.peek()): minHeap.peek());
    }


    public static void main(String[] args) {
        int nums[] = new int[]{1,55,2,3,66,78,-1,2,44,2,11,78,66,55,89,-2,-100,1,2,3};
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<nums.length; i++){
            list.add(nums[i]);
            System.out.println(median(list, i));
        }
    }

}