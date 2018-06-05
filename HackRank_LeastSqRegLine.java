import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        double sigmaX = 0, sigmaY = 0, sigmaXY = 0;
        double sigmaX2 = 0;
        Scanner sc = new Scanner(System.in);
        int n = 5;
        for(int i = 0; i < n; i++){
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            sigmaX += x;
            sigmaX2 += x*x;
            sigmaY += y;
            sigmaXY += x*y;
        }
        double meanX = sigmaX/n, meanY = sigmaY/n;
        double b = (n*sigmaXY - sigmaX*sigmaY)/(n*sigmaX2 - sigmaX*sigmaX);
        double a = meanY - meanX*b;
        System.out.printf("%.3f", a+80*b);
    }
}
