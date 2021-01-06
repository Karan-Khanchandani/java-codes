package problem;

import java.util.ArrayList;
import java.util.List;

/*
Calculate total number of combinations in which a player can score the given score
*/

public class Problem_17_1{


    public static int count_no_of_ways(List<Integer> individualPlays, int finalScore){

        int dpArray[][] = new int[individualPlays.size()][finalScore+1];
        for(int i = 0; i < individualPlays.size(); i++){
            dpArray[i][0] = 1;
            for(int j = 1; j<=finalScore; j++){
                int withoutPlay = (i-1) >= 0 ? dpArray[i-1][j] : 0;
                int withPlay = (j >= individualPlays.get(i)) ? dpArray[i][j - individualPlays.get(i)] : 0;
                dpArray[i][j] = withoutPlay + withPlay;
            }

        }
        return dpArray[individualPlays.size() - 1][finalScore];
    }

    public static void main(String[] args) {
        List<Integer> individualPlays = new ArrayList<>();
        individualPlays.add(2);
        individualPlays.add(3);
        individualPlays.add(7);

        int finalScore = 12;
        int no_of_ways =  count_no_of_ways(individualPlays, finalScore);
        System.out.println(no_of_ways);
    }
}