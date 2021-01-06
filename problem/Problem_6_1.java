package problem; /**
 Problem Description:
 Write a program that takes an array A and an index i into A, and rearranges the
elements such that all elements less than A[i] (the "pivot") appear first, followed by
elements equal to the pivot, followed by elements greater than the pivot.
 */
import java.util.*;
 public class Problem_6_1{

     public static void partition(int arr[],int pivot, int n){
        int pivotElem = arr[pivot];
        int smaller = 0, equal = 0, larger = n - 1;
        while(equal < larger){
            if(arr[equal] < pivotElem){
                int temp = arr[equal];
                arr[equal] = arr[smaller];
                arr[smaller] = temp;
                equal++;
                smaller++;

            }else if(arr[equal] == pivotElem){
                equal++;
            }
            else{
                --larger;
                int temp = arr[equal];
                arr[equal] = arr[larger];
                arr[larger] = temp;
            }
        }
        
        
     }

     public static void main(String[] args) {
         int arr[] = new int[]{1, 3, 9, 10, 2, 1, 3 ,7};
         partition(arr, 2, arr.length);
         for(int i = 0; i< arr.length; i++){
             System.out.print(arr[i] + ", ");
         }

     }
 }