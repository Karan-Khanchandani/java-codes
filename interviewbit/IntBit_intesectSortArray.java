package interviewbit;

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0, j =0;
        while(i < A.size() && j < B.size()){
            if(A.get(i).intValue() == B.get(j).intValue()){
                res.add(A.get(i));
                i++;j++;
            }else if(A.get(i).intValue() < B.get(j).intValue()){
                i++;
            }else{
                j++;
            }
        }
        return res;
    }
}
