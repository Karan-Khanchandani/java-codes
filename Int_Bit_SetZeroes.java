//This solution is n^2 but gives TLE
public class Solution {
    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        int m = a.get(0).size();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a.get(i).get(j) == 0){
                    for(int k = 0; k < m; k++){
                        if(a.get(i).get(k) != 0)
                        a.get(i).set(k , 2);
                    }
                    for(int l = 0; l < n; l++){
                        if(a.get(l).get(j) != 0) 
                        a.get(l).set(j , 2);
                    }
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a.get(i).get(j) == 2){
                    a.get(i).set(j, 0);
                }
            }
        }
    }
}
