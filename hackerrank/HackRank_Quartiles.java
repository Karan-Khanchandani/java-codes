package hackerrank;

import java.io.*;
import java.util.*;

public class HackRank_Quartiles {
    static int findMedian(int[] a, int start, int end){
        int n = end - start + 1;
        if(n%2 == 0){
            return (a[start+n/2] + a[start + n/2 - 1])/2;
        }
        return a[start + n/2];
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named hackerrank.Solution. */
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) a[i] = sc.nextInt();
        Arrays.sort(a);
        int q1, q2, q3;
        if(n%2 == 0){
            q2 = findMedian(a,0,n-1);
            q1 = findMedian(a,0,n/2-1);
            q3 = findMedian(a,n/2,n-1);
        }else{
            q2 = findMedian(a,0,n-1);
            q1 = findMedian(a,0,n/2-1);
            q3 = findMedian(a,n/2+1,n-1);
        }
        
        System.out.println(q1);
        System.out.println(q2);
        System.out.println(q3);
    }
}
