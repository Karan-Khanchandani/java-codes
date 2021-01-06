package problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Problem Description:
Schedule to minimize waiting time
*/

public class Problem_18_2{
    
    public static int minimize_time(List<Integer> service_time){
        Collections.sort(service_time);
        int result = 0;
        for(int i = 0; i < service_time.size(); i++){
            int num_remaining_queries = service_time.size() - (i+1);
            result += service_time.get(i)*num_remaining_queries;
        }
        return result;
    }
    public static void main(String[] args) {
        List<Integer> service_time = new ArrayList<>(Arrays.asList(2, 5, 1, 3));
        System.out.println(minimize_time(service_time));
    }
}