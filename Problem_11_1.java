import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/*
Problem Description:
Merge sorted lists into one list. List must be sorted
*/

public class Problem_11_1{

    public static class ArrayEntry{
        public Integer value;
        public Integer arrayId;

        public ArrayEntry(Integer value, Integer arrayId){
            this.value = value;
            this.arrayId = arrayId;
        }
    }

    public static List<Integer> mergeSortedLists(List<List<Integer>> sortedLists){

        List<Iterator<Integer>> iters = new ArrayList<>(sortedLists.size());

        for(List<Integer> array : sortedLists){
            iters.add(array.iterator());
        }

        PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>(
            ((int)sortedLists.size()), new Comparator<ArrayEntry>() {
                @Override
                public int compare(ArrayEntry o1, ArrayEntry o2){
                    return Integer.compare(o1.value, o2.value);
                }
            }
        );

        for(int i = 0; i < iters.size(); i++){
            if(iters.get(i).hasNext()){
                minHeap.add(new ArrayEntry(iters.get(i).next(), i));
            }      
        }

        List<Integer> result = new ArrayList<>();

        while(!minHeap.isEmpty()){
            ArrayEntry headEntry = minHeap.poll();
            result.add(headEntry.value);

            if(iters.get(headEntry.arrayId).hasNext()){
                minHeap.add(new ArrayEntry(iters.get(headEntry.arrayId).next(),headEntry.arrayId));
            }

        }

        return result;
    }

    public static void printList(List<Integer> list){
        for(Integer i : list){
            System.out.print(i + " , ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(0,6,28));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(0,6));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(3,5,7));
        List<Integer> list4 = new ArrayList<>();


        List<List<Integer>> list = new ArrayList<>(Arrays.asList(list1, list2, list3));
        list4 = mergeSortedLists(list);
        printList(list4);

    }
}