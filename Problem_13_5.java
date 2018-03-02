import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;



/*
Find the k most frequent queries
*/


public class Problem_13_5{

    public static class StringWithCount{
        public String string;
        public Integer count;
        
        public StringWithCount(String string, Integer count){
            this.string = string;
            this.count = count;
        }
    }

    public static class Compare implements Comparator<StringWithCount>{
        public int compare(StringWithCount s1, StringWithCount s2){
            return (s1.count > s2.count)?  -1 :(s1.count == s2.count ? 0 : 1);
        }

        public static final Compare COMPARE = new Compare();
    }

    public static List<String> findKMostFrequent(List<String> queries, int k){

        //HashMap
        Map<String, Integer> occurences = new HashMap<>();
        for(String s: queries){
            if(!occurences.containsKey(s)){
                occurences.put(s, 1);
            }else{
                occurences.put(s, occurences.get(s) + 1);
            }
        }

        //Take map into list
        List<StringWithCount> stringCount = new ArrayList<>();

        for(Map.Entry<String, Integer> entry: occurences.entrySet()){
            stringCount.add(new StringWithCount(entry.getKey(), entry.getValue()));
        }

        //List has all entries with count

        List<String> result = partition(stringCount, k, Compare.COMPARE);

        return result;

    }


    public static List<String> partition(List<StringWithCount> arr, int k, Comparator<StringWithCount> cmp){

        int left = 0, right = arr.size() - 1;
        Random random = new Random(0);

        List <String> result = new ArrayList<>();

        while(left <= right){
            int pivotIdx = random.nextInt(right - left + 1) + left;
            pivotIdx = partitionUtil(arr, left, right, pivotIdx, k, cmp);

            if(pivotIdx == k-1){
                for(int i = pivotIdx; i >= 0 ; i--){
                    result.add(arr.get(i).string);
                }
                return result;
            }else if( pivotIdx < k -1){
                left = pivotIdx -1;
            }else{
                right =pivotIdx + 1;
            }
        }

        return result;
    }

    public static int partitionUtil(List<StringWithCount> arr,int left, int right,int pivot, int k, Comparator<StringWithCount> cmp){

        int newpivotIdx = left;

        StringWithCount pivotValue = arr.get(pivot);
        Collections.swap(arr, pivot, right);

        for(int i = left; i < right; i++){
            if(cmp.compare(arr.get(i), pivotValue) < 0){
                Collections.swap(arr, i, newpivotIdx++);
            }
        }

        Collections.swap(arr, newpivotIdx, right);
        
        return newpivotIdx;

    }

    public static void printList(List<String> list){
        for(String s: list){
            System.out.print(s +" , ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<String> queries = new ArrayList<>();
        queries.add("Google");
        queries.add("Microsoft");
        queries.add("Google");
        queries.add("Amazon");
        queries.add("Amazon");
        queries.add("Google");
        queries.add("Amazon");
        queries.add("Google");
        queries.add("Goldman");
        queries.add("Microsoft");

        List<String> k_most_frequent = findKMostFrequent(queries, 2);

        printList(k_most_frequent);
    }
}