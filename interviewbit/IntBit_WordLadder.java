package interviewbit;

public class Solution {
    static class Pair{
        String s;
        int dist;
        public Pair(String s, int d){
            this.s = s;
            this.dist = d;
        }
    }
    public int ladderLength(String start, String end, ArrayList<String> dictV) {
        Set<String> dict = new HashSet<>(dictV);
        Set<String> visited = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, 0));

        while(!q.isEmpty()){
            Pair top = q.poll();
            if(top.s.equals(end)){
                return top.dist + 1;
            }
            visited.add(top.s);
            ArrayList<String> adj = getAdj(top.s, dict);
            for(int i = 0; i < adj.size(); i++){
                if(!visited.contains(adj.get(i)))
                q.add(new Pair(adj.get(i), top.dist + 1));
            }
        }
        return 0;
    }
    
    public ArrayList<String> getAdj(String s, Set<String> dict){
        ArrayList<String> res = new ArrayList<>();
        
       
            for(int i = 0; i < s.length(); i++){
                char[] str = s.toCharArray();
                for(char c = 'a'; c <= 'z'; c++){
                    str[i] = c;
                    String stri = new String(str);
                    if(dict.contains(stri)){
                        res.add(stri);
                    }
                }
            }
        
        return res;
    }
}
