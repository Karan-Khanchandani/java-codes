package leetcode;

class Solution {
    private static int[] rank, p;
    
    static int findSet(int i){
        return(p[i] == i) ? i : (p[i] = findSet(p[i]));
    }
    
    static boolean isSameSet(int i, int j){
        return findSet(i) == findSet(j);
    }
    
    static void union(int i, int j){
        if(!isSameSet(i,j)){
            int x = findSet(i);
            int y = findSet(j);
            if(rank[x] > rank[y]){
                p[y] = x;
            }else{
                p[x] = y;
                if(rank[x] == rank[y]) rank[y]++;
            }
        }
    }
    
    public int findCircleNum(int[][] M) {
        //Union find
        int n = M.length;
        if(n == 0) return 0;
        p = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++)p[i] = i;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(M[i][j] == 1){
                    union(i,j);
                }
            }
        }
        for(int i = 0; i < n; i++) p[i] = findSet(p[i]); 
        HashSet<Integer> res = new HashSet<>();
        for(int i = 0; i < n; i++) res.add(p[i]);
        
        return res.size();
    }
    
}
