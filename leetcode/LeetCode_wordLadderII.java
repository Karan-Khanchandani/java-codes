package leetcode;

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dictionary = new HashSet<String>(wordList);
        HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<>();
        HashMap<String, Integer> distance = new HashMap<>();
        List<List<String>> results = new ArrayList<>();
        
        ArrayList<String> solution = new ArrayList<>();
        dictionary.add(beginWord);
        
        bfs(beginWord, endWord, dictionary, nodeNeighbors, distance);
        dfs(beginWord, endWord, nodeNeighbors, distance, solution, results); 
        return results;
        
    }
    
    public static void bfs(String beginWord, String endWord, HashSet<String> dictionary, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance){
        for(String s: dictionary){
            nodeNeighbors.put(s, new ArrayList<>());
        }
        
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        distance.put(beginWord, 0);
        
        while(!q.isEmpty()){
            int count = q.size();
            for(int i = 0; i < count; i++){
                String curr = q.poll();
                int curDistance = distance.get(curr);
                ArrayList<String> neighbors = getNeighbors(curr, dictionary);
                for(String neighbor : neighbors){
                    nodeNeighbors.get(curr).add(neighbor);
                    if (!distance.containsKey(neighbor)) {// if we have not previously visited this node
                      distance.put(neighbor, curDistance + 1); //increment distance we have travelled.
                      if (endWord.equals(neighbor)){//if we have reached the end.
                         // return;
                          break;
                          //we don't want to return as there may well be more paths from start to end. So we need to break instead.
                      }
                      else{
                          q.offer(neighbor);///add neighbour for next level
                      }
                    }
                }
            }
        }
    }
    
    public static ArrayList<String> getNeighbors(String word, HashSet<String> dictionary){
        char[] chs = word.toCharArray();
        ArrayList<String> res = new ArrayList<>();
        for(char ch = 'a'; ch <= 'z'; ch++){
            for(int i = 0; i < chs.length; i++){
                if(ch != chs[i]){
                    char save = chs[i];
                    chs[i] = ch;
                    if(dictionary.contains(String.valueOf(chs))){
                        res.add(String.valueOf(chs));
                    }
                    chs[i] = save;
                }
            }
        }
        return res;
    }
    private static void dfs(String beginWord, String endWord, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance, ArrayList<String> individualSequence, List<List<String>> results) {
    
    individualSequence.add(beginWord);
    if (endWord.equals(beginWord)) {//Base case for beginWord that has reached endWord and individualSequence has the complete path from the BeginWord to EndWord. So add to the final results list.
       results.add(new ArrayList<String>(individualSequence));
    } else {//We have not reached the end so we must perform DFS on the neighbours.
       for (String next : nodeNeighbors.get(beginWord)) {  //For each neighbour in the beginWord perform DFS to find the next path
           
           
            if (distance.get(next) == distance.get(beginWord) + 1) {// This is just in case that the next node is the next level of current node， otherwise it can be one of the parent nodes of current node，or it is not the shortest node 
            // Since in BFS, we record both the next level nodes and the parent node as neighbors of current node. use distance.get(beginWord)+1 we can make sure the path is the shortest one.
                 dfs(next, endWord, nodeNeighbors, distance, individualSequence, results);
            }
        }
    }        

    //Copy sequence and look at all the elements inside of it to see what the fuck is going on   
   individualSequence.remove(individualSequence.size() - 1); //I think this statement is for backtracking solutions that are invalid.
   
   //You keep on going down the 'tree' until you get to 'cog'. Add the sequence to the results.
   //Then you need to backtrack the neighbours and travel down the tree on a different path. In this example go to '3' then travel down that path to 'cog' again.
   //Keep removing until you backtrack to the very start of beginWord which in this case is "hit".
}
}
