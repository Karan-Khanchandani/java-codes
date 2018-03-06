import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description:
Implement Knapsack Problem
*/

public class Problem_17_6{

    public static class Item{
        public Integer value;
        public Integer weight;

        public Item(Integer value, Integer weight){
            this.value = value;
            this.weight = weight;
        }

    }

    public static int optimalSubjectToCapacity(List<Item> items, int capacity){
        int V[][] = new int[items.size()][capacity+1];

        for(int[] rows: V){
            Arrays.fill(rows, -1);
        }
        return optimalSubjectToItemAndCapacity(V, items, items.size() -1, capacity);
    }

    public static int optimalSubjectToItemAndCapacity(int[][] V, List<Item> items, int k, int capacity){
        if(k < 0){
            return 0;
        }

        if(V[k][capacity] == -1){
        int withoutItem = (k > 0) ? optimalSubjectToItemAndCapacity(V, items, k-1, capacity) : 0;
        int withItem = capacity < items.get(k).weight ? 0 : items.get(k).value + optimalSubjectToItemAndCapacity(V, items, k-1, capacity - items.get(k).weight );
         V[k][capacity] = Math.max(withItem, withoutItem);   
        }

        return V[k][capacity];
        
    }

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item(60,5));
        items.add(new Item(50,3));
        items.add(new Item(70,4));
        items.add(new Item(30,2));

        int capacity = 5;
        System.out.println(optimalSubjectToCapacity(items, capacity));
    }
}