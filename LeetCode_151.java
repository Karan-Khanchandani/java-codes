
public class LeetCode_151{
    public static String reverseWords(String s) {
       
        s = process_spaces(s);
         
        s  = reverse_string(s, 0, s.length());
        int lastSpace = 0;
        for(int i = 0; i < s.length() ; i++){
            if(s.charAt(i) == ' '){
                s = reverse_string(s, lastSpace, i);
                lastSpace = i;
            }
        }
        s = reverse_string(s, lastSpace, s.length());
         
         return s;
     }
     
     public static  String process_spaces(String s){
         
         //remove leading spaces
         int i = 0;
         while( i < s.length() && s.charAt(i) == ' '){
             i++;
         }
         
        //remove trailing spaces
        int j = s.length() -1;
         while(  j > 0 && s.charAt(j) == ' '){
            j--;
         }

         StringBuilder sb = new StringBuilder(s.substring(i, j));
         
         for(i = 0; i < s.length(); i++){
             if(s.charAt(i) == ' '){
                 sb.append(s.charAt(i));
                 while(s.charAt(i) == ' '){
                     i++;
                 }
             }
             sb.append(s.charAt(i));
         }
         
         return sb.toString();
     }
     
     public static String reverse_string(String s, int startIdx, int endIdx){
         StringBuilder sb = new StringBuilder(s);
         for(int i = startIdx, j = endIdx - 1; i < j; i++, j--){
             Character c = s.charAt(i);
             sb.setCharAt(i , sb.charAt(j));
             sb.setCharAt(j, c);
         }
         
         return sb.toString();
     }


    public static void main(String[] args) {
        String s = " ";
        s = reverseWords(s);
        System.out.println(s);
    }
}