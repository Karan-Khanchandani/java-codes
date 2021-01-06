package problem;

import java.util.Collections;

/*
Problem Description"
Apply permutation to the given array
*/

public class Problem_6_9{

    public static void printArray(int arr[]){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " , ");
        }
        System.out.println();
    }

    public static void swap(int arr[], int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void applyPermutation(int[] arr, int[] perm){

        for(int i = 0; i < arr.length; i++){
            int next = i;
            while(perm[next] >= 0){

                swap(arr, i, perm[next]);
                int temp = perm[next];
                perm[next] = perm[next] - perm.length;
                next = temp;

                

            }
        }

        for(int i = 0 ;i < perm.length; i++){
            perm[i] += perm.length;
        }

    }
    public static void main(String[] args) {
        int[] arr = {1,2 ,3 ,4};
        int[] perm = {3, 2, 1 ,0};
        printArray(arr);
        applyPermutation(arr, perm);
        printArray(arr);
    }
}