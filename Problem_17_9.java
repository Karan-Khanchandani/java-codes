import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem Description:
Pickup coins from either end such that revenue is max
two players are playing
*/

public class Problem_17_9{
    public static int maxRevenue(List<Integer> coins){
        int R[][] = new int[coins.size()][coins.size()];
        return maxRevenueHelper(R, 0, coins.size() -1 , coins);
    }

    public static int maxRevenueHelper(int [][]R, int a, int b, List<Integer> coins){
        if(a > b){
            return 0;
        }
        if(R[a][b] == 0){
            int maximumA = coins.get(a) + Math.min(maxRevenueHelper(R, a+2,b, coins), maxRevenueHelper(R, a+1, b-1, coins));
            int maximumB = coins.get(b) + Math.min(maxRevenueHelper(R, a,b-2, coins), maxRevenueHelper(R, a+1, b-1, coins));
            R[a][b] = Math.max(maximumA, maximumB);
        }
        return R[a][b];
    }
    public static void main(String[] args) {
        List<Integer> coins = new ArrayList<>(Arrays.asList(10, 25, 5, 1, 10, 5));
        System.out.println(maxRevenue(coins));
    }
}