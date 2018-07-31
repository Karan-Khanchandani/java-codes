public class Solution {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(A.size() == 0) return res;
        Collections.sort(A);
        permuteUtil(res, A, new ArrayList<>(), 0, A.size());
        return res;
    }
    
    public void permuteUtil(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> A, ArrayList<Integer> temp, int curr, int n){
        if(curr == n){
            ArrayList<Integer> a = new ArrayList<>(temp);
            res.add(a);
            return;
        }
        for(int i = 0; i < n; i++){
            if(temp.contains(A.get(i))) continue;
            temp.add(A.get(i));
            permuteUtil(res, A, temp, curr + 1, n);
            temp.remove(temp.size() - 1);
        }
    }
}
