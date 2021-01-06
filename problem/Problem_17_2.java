package problem;

import java.util.Arrays;

/*
Problem Description:
Calculate LEVENSHTEIN DISTANCE
*/

public class Problem_17_2{

    public static int calc_levenshtein_distance(String a, String b){
        int arr[][] = new int[a.length()][b.length()];
        for(int row[]: arr){
            Arrays.fill(row, -1);
        }

        return calc_levenshtein_distanceUtil(arr,a.length()-1, a, b.length() -1, b);
    }

    public static int calc_levenshtein_distanceUtil(int arr[][], int a_idx, String a, int b_idx, String b){
        if(a_idx < 0){
            return b_idx + 1;
        }
        if(b_idx < 0){
            return a_idx + 1;
        }
        if(a.charAt(a_idx) == b.charAt(b_idx)){
            return calc_levenshtein_distanceUtil(arr, a_idx - 1, a, b_idx - 1, b);
        }else{
            int insertion = calc_levenshtein_distanceUtil(arr, a_idx, a, b_idx - 1, b);
            int deletion = calc_levenshtein_distanceUtil(arr, a_idx - 1, a, b_idx, b);
            int subtitution = calc_levenshtein_distanceUtil(arr, a_idx -1 , a, b_idx -1, b);
            arr[a_idx][b_idx] = 1 + Math.min(insertion, Math.min(deletion, subtitution));
        }

        return arr[a_idx][b_idx];
    }

    public static void main(String[] args) {
        String a = "Carthorse";
        String b = "Orchestra";
        int levenshtein_distance = calc_levenshtein_distance(a, b);
        System.out.println(levenshtein_distance);
    }
}