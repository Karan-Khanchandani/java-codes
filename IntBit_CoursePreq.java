public class Solution {
    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        // int[][] edgeMat = new int[A+1][A+1];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] indegree = new int[A+1];
        for(int i = 0; i < B.size(); i++){
            int pre = B.get(i);
            int next = C.get(i);
            if(!map.containsKey(pre)){
                map.put(pre, new ArrayList<>());
            }
            ArrayList<Integer> list = map.get(pre);
            list.add(next);
            indegree[next]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= A; i++){
            if(indegree[i] == 0) q.add(i);
        }
        
        int count = 0;
        while(!q.isEmpty()){
            int course = q.poll();
            count++;
            ArrayList<Integer> cs = map.get(course);
            if(cs != null){
                for(int j = 0; j < cs.size(); j++){
                    indegree[cs.get(j)]--;
                    if(indegree[cs.get(j)] == 0) q.add(cs.get(j));
                }
            }
        }
        
        return count == A ? 1 : 0;
    }
}
