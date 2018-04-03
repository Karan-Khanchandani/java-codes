public class Solution {
    public String reverseWords(String s) {
        if(s == null){
            return null;
        }
        
        char[] str = s.toCharArray();
        
        reverse(str, 0, str.length - 1);
        
        reverseWords(str, str.length);
        
        return cleanSpaces(str, str.length);
        
    }
    
    public void reverseWords(char[] str, int n){
        int i = 0, j = 0;
        
        while(i < n){
            while(i < j || i < n && str[i] == ' ') i++;
            while(j < i || j < n && str[j] != ' ') j++;
            
            reverse(str, i, j - 1);
        }
    }
    
    
    public String cleanSpaces(char[] str, int n){
        //remove leading
        int i = 0, j = 0;
        while(i < n){
            while(i < n && str[i] == ' ')i++;
            while(i < n && str[i] != ' ')str[j++] = str[i++];
            while(i < n && str[i] == ' ')i++;
            if(i < n) str[j++] = ' ';
        }
        
        return new String(str).substring(0, j);
        
        
    }
    
    
    public void reverse(char[] str, int i, int j){
        while(i < j){
            char t = str[i];
            str[i] = str[j];
            str[j] = t;
            i++; j--;
        }
    }
}
