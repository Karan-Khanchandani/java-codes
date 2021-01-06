package problem;

/**
 Problem Description:

 */

 public class Problem_6_4{

    public static boolean isAdvPossible(int arr[]){
        int max_reach_so_far = 0;
        for(int i = 0 ;i < arr.length; i++){
            //first check if I can reach current tile
            //then check how much I can reach farther
            if(i > max_reach_so_far){
                return false;
            }
            else{
                max_reach_so_far = Math.max(max_reach_so_far, i + arr[i]);
            }
        }
        if(max_reach_so_far >= arr.length-1)
        return true;

        return false;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{3,3, 1,0, 2,0, 1};
        System.out.println(isAdvPossible(arr));
        arr = new int[]{2,1,0,0,0,0};
        System.out.println(isAdvPossible(arr));
    }

 }