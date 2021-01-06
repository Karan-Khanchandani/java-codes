package problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Problem Description:
Assign tasks to works exactly two tasks such that the time taken by them to complete all tasks is minimum
*/

public class Problem_18_1{
    private static class PairedTasks{
        private Integer task1;
        private Integer task2;

        public PairedTasks(Integer task1, Integer task2){
            this.task1 = task1;
            this.task2 = task2;
        }
    }

    public static List<PairedTasks> assignTasks(List<Integer> tasks){
        List<PairedTasks> paired_tasks = new ArrayList<>();
        Collections.sort(tasks);
        for(int i = 0, j = tasks.size() -1; i < j; i++, j--){
            paired_tasks.add(new PairedTasks(tasks.get(i), tasks.get(j)));
        }
        return paired_tasks;
    }

    public static void printTasks(List<PairedTasks> paired_tasks){
        for(PairedTasks p : paired_tasks){
            System.out.print("< " + p.task1 + ", " + p.task2 + " >" + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> tasks = new ArrayList<>(Arrays.asList(5, 2, 1, 6, 4, 4));
        List<PairedTasks> paired_tasks =  assignTasks(tasks);
        printTasks(paired_tasks);
    }
}