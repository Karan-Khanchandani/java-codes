package interviewbit;

public class Solution {
    public ArrayList<String> wordBreak(String A, ArrayList<String> B) {
    ArrayList<String> res =  DFS(A, B, new HashMap<String, ArrayList<String>>());
    HashSet<String> set = new HashSet<>(res);
    res.clear();
    for(String s: set){
        res.add(s);
    }
    Collections.sort(res);
    return res;
    }       

    // DFS function returns an array including all substrings derived from s.
    ArrayList<String> DFS(String s, ArrayList<String> wordDict, HashMap<String, ArrayList<String>>map) {
        if (map.containsKey(s)) 
            return map.get(s);

        ArrayList<String>res = new ArrayList<String>();     
        if (s.length() == 0) {
            res.add("");
            return res;
        }               
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist) 
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);               
            }
        }       
        map.put(s, res);
        return res;
    }
}
