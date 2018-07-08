public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Collections.sort(A);
        subsetsUtil(A, 0, new ArrayList<>(), res);
        return res;
        
    }
    
    public void subsetsUtil(ArrayList<Integer> A,int index, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res){
         res.add(new ArrayList<>(temp));
        for(int i = index; i < A.size(); i++){
            temp.add(A.get(i));
            subsetsUtil(A,i+ 1,temp, res);
            temp.remove(temp.size() - 1);
        }
        return;
    }
}
