package interviewbit;

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> twoSum(final List<Integer> A, int B) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < A.size(); i++){
            int first = A.get(i);
            int second = B - first;
            
                if(map.containsKey(second)){
                    res.add(map.get(second) + 1);
                    res.add(i + 1);
                    break;
                }
            if(map.containsKey(first)){
                
            }else{
                map.put(first, i);
            }
        }
        return res;
    }
}
