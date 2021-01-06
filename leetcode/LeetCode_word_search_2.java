package leetcode;

class Solution {
    
    public static class Trie{
        public Trie[] children;
        public boolean isWord;
        public String str;
        public Trie(){
            this.children = new Trie[26];
            this.isWord = false;
            this.str = null;
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        
        
        Trie root = new Trie();
        //insert words into trie
        for(String s : words){
            Trie iter = root;
            for(int i = 0; i < s.length(); i++){
                int idx = (int)(s.charAt(i) - 'a');
                if(iter.children[idx] == null){
                    iter.children[idx] = new Trie();
                }
                iter = iter.children[idx];
            }
            iter.isWord = true;
            iter.str = s;
        }
        
        List<String> result = new ArrayList<>();
        
        for(int i = 0; i < board.length ; i++){
            for(int j = 0; j < board[i].length; j++){
                dfs(board, i, j, root, result);
               }
        }
        
        return result;
        
    }
    
    
    public void dfs(char[][] board,  int  rowIdx, int colIdx, Trie root, List<String> result){
        char c = board[rowIdx][colIdx];
        
        if(c == '#' || root.children[c - 'a'] == null){
            return;
        }
        root = root.children[c - 'a'];
        if(root.str != null){
            result.add(root.str);
            root.str = null;
        }
        
        board[rowIdx][colIdx] = '#';
        if(rowIdx > 0) dfs(board,  rowIdx- 1, colIdx, root, result);
        if(colIdx > 0) dfs(board, rowIdx, colIdx - 1, root, result);
        if(rowIdx < board.length - 1) dfs(board, rowIdx + 1, colIdx, root, result);
        if(colIdx < board[0].length - 1) dfs(board, rowIdx, colIdx + 1, root, result);
        board[rowIdx][colIdx] = c;
        
    }
}
