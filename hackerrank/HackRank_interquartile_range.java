package hackerrank;

import java.io.*;
import java.util.*;

public class HackRank_interquartile_range {
    static double findMedian(int[] arr, int start, int end){
        int n = end - start + 1;
        if(n%2 == 0){
            return 0.5*(arr[start + n/2-1] + arr[start + n/2]);
        }
        return 1.0*arr[start + n/2];
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named hackerrank.Solution. */
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] f= new int[n];
        int numElems = 0;
        int a[] = new int[n];
        for(int i = 0; i < n; i++) a[i] = sc.nextInt();
        for(int i = 0;i < n; i++){
            f[i] = sc.nextInt();
            numElems += f[i];
        }
        int arr[] = new int[numElems];
        int k = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < f[i]; j++){
                arr[k++] = a[i];
            }
        }
        Arrays.sort(arr);
        double q1, q3;
        if(numElems%2 == 0){
            q1 = findMedian(arr,0,numElems/2-1);
            q3 = findMedian(arr,numElems/2, numElems-1);
        }else{
            q1 = findMedian(arr,0,numElems/2-1);
            q3 = findMedian(arr,numElems/2+1, numElems-1);
        }
        System.out.printf("%.1f", q3-q1);
    }
}
