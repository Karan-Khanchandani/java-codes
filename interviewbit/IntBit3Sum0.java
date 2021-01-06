package interviewbit;

public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        Collections.sort(A);
        Set<ArrayList<Integer>> res= new HashSet<>();
        int n = A.size();
        for(int i = 0; i < n-2; i++){
            for(int j = i+1, k= n-1; j< k;){
                if(A.get(i) + A.get(j) + A.get(k) == 0){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(A.get(i));temp.add(A.get(j));temp.add(A.get(k));
                    res.add(temp);
                    j++;
                }else if(A.get(i) + A.get(j) + A.get(k) > 0){
                    k--;
                }else{
                    j++;
                }
            }
        }
        ArrayList<ArrayList<Integer>> ans= new ArrayList<>(res);
        
        return ans;
    }
}
