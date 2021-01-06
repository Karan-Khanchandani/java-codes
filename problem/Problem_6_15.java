package problem;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/*
Problem Description:
Generate non-uniform random number with its given probability
*/

public class Problem_6_15{

    public static int nonUniformProbability(List<Integer> values, List<Double> probabilities){
        List<Double> cumu_prob = new ArrayList<>();
        cumu_prob.add(0.0);
        
        for(Double p : probabilities){
            cumu_prob.add(p + cumu_prob.get(cumu_prob.size() - 1));
        }

        Random r = new Random();

        Double v = r.nextDouble();

        int idx = Collections.binarySearch(cumu_prob, v);

        if(idx < 0){
            int idx1 = (Math.abs(idx)) - 1 - 1;
            return values.get(idx1);
        }else{
            return values.get(idx);
        }

    }

    public static void main(String[] args) {
        List<Double> probabilities = new ArrayList<>(Arrays.asList(0.5, 0.2, 0.1, 0.1, 0.1));
        List<Integer> values = new ArrayList<>(Arrays.asList(0,1,2,3,4));

        for(int i = 0; i < 20; i++){
            System.out.print(nonUniformProbability(values, probabilities) + " ");
        }
    }
}