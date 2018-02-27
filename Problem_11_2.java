import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;

/*
Merge alternate increasing and decreasing array
*/

public class Problem_11_2{

    public static class ArrayEntry{
        public Integer value;
        public Integer arrayId;

        public ArrayEntry(Integer value, Integer arrayId){
            this.value = value;
            this.arrayId = arrayId;
        }
    }

    public static enum SubArrayType {INCREASING, DECREASING};


    public static void printList(List<Integer> list){
        for(Integer i : list){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static Integer[] mergeSortedLists(Integer[] num){
       List<List<Integer>> sortedLists= new ArrayList<>();
       SubArrayType subArrayType = SubArrayType.INCREASING;
       int startIndex = 0;

       //populate Lists

       for(int i = 1; i<= num.length; i++){
            if(
            i == num.length || 
            ((num[i-1] > num[i]) && subArrayType == SubArrayType.INCREASING) ||
            ((num[i-1] <= num[i]) && subArrayType == SubArrayType.DECREASING)){

                if(subArrayType == SubArrayType.INCREASING){
                sortedLists.add(new ArrayList<Integer>(Arrays.asList(Arrays.copyOfRange(num, startIndex, i))));
            }else{
                List<Integer> revList = new ArrayList<Integer>(Arrays.asList(Arrays.copyOfRange(num, startIndex, i)));
                //printList(revList);
                Collections.reverse(revList);
                sortedLists.add(revList);
            }
                startIndex = i;
                subArrayType = (subArrayType == SubArrayType.INCREASING) ? SubArrayType.DECREASING:SubArrayType.INCREASING;
            }
       }

       List<Iterator<Integer>> iters= new ArrayList<>(sortedLists.size());

       for(int i = 0; i < sortedLists.size(); i++){
           iters.add(sortedLists.get(i).iterator());
       }
    

       PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>(((int)sortedLists.size()),
       new Comparator<ArrayEntry>() {
        @Override
                public int compare(ArrayEntry o1, ArrayEntry o2){
                    return Integer.compare(o1.value, o2.value);
                }
       });
       
       
       for(int i = 0; i < iters.size(); i++){
           if(iters.get(i).hasNext()){
               minHeap.add(new ArrayEntry(iters.get(i).next(), i));
           }
       }

       Integer[] results = new Integer[num.length];
       int i = 0;
       while(!minHeap.isEmpty()){
           ArrayEntry headEntry = minHeap.poll();
        results[i] = headEntry.value;
        i++;
        if(iters.get(headEntry.arrayId).hasNext()){
            minHeap.add(new ArrayEntry(iters.get(headEntry.arrayId).next(), headEntry.arrayId));
        }

       }
        
       return results;
    }


    public static void main(String[] args) {
        Integer num[] = new Integer[]{57, 131 ,493, 294 ,221, 339 ,418 ,452, 442, 190};
        num = mergeSortedLists(num);
        for(int i = 0; i< num.length; i++)
            System.out.print(num[i] + " ");
        System.out.println();
    }
}