package interviewbit;

public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Collections.sort(A);
        subsetsUtil(A, 0, new ArrayList<>(), res);
        return res;
    }
    
    public void subsetsUtil(ArrayList<Integer> A, int start, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>>res){
        res.add(new ArrayList<>(temp));
        for(int i = start; i < A.size(); i++){
            if(i > start && A.get(i) == A.get(i-1))continue;
            temp.add(A.get(i));
            subsetsUtil(A, i+1, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}
