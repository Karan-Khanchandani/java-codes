package interviewbit;

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < A.size(); i++){
            String s = A.get(i);
            char[] t = s.toCharArray();
            Arrays.sort(t);
            String key = String.valueOf(t);
            //System.out.println(key);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<Integer>());
            }
            ArrayList<Integer> list = map.get(key);
            list.add(i+1);
        }
        
        
        for(Map.Entry<String, ArrayList<Integer>> e : map.entrySet()){
            res.add(e.getValue());
        }
        return res;
    }
}
