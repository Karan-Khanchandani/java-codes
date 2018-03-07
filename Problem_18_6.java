import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem Description:
City and gallons
*/

public class Problem_18_6{
    private static class CityAndRemainingGas{
        public Integer city;
        public Integer remainingGas;
        
        public CityAndRemainingGas(Integer city, Integer remainingGas){
            this.city = city;
            this.remainingGas = remainingGas;
        }
    }
    private static final int MPG = 20;

    private static int ampleCity(List<Integer> gallons, List<Integer> distances){
        int remainingGallons = 0;
        CityAndRemainingGas min = new CityAndRemainingGas(0, 0);
        for(int i = 1; i < gallons.size(); i++){
            remainingGallons += gallons.get(i-1) - distances.get(i-1)/MPG;
            if(remainingGallons < min.remainingGas){
                min = new CityAndRemainingGas(i, remainingGallons);
            }
        }
        return min.city;
    }

    public static void main(String[] args) {
        List<Integer> distances = new ArrayList<>(Arrays.asList(200, 400, 600,200, 100, 900 ,600));        
        List<Integer> gallons = new ArrayList<>(Arrays.asList(5, 30, 25,10, 10, 50 ,20));

        System.out.println(ampleCity(gallons, distances));
    }
}