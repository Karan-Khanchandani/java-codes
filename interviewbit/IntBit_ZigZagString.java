package interviewbit;

public class Solution {
    public String convert(String A, int B) {
        StringBuilder sb = new StringBuilder();
        if(B == 1) return A;
        if(B == 2){
            for(int i = 0; i < A.length(); i+=2){
                sb.append(A.charAt(i));
            }
            for(int i = 1; i < A.length(); i+=2){
                sb.append(A.charAt(i));
            }
            return sb.toString();
        }
        
        for(int i = 0; i < A.length(); i+= 2*(B - 1)){
            sb.append(A.charAt(i));
        }
        
        //do something
        for(int i = 1; i < B - 1; i++){
            for(int j = i; j < A.length(); j+= 2*(B - 1)){
                sb.append(A.charAt(j));
                int k = j + 2*(B - 1 - i);
                if(k < A.length()){
                    sb.append(A.charAt(k));
                }
            }
            
        }
        
        //last row
        for(int i = B - 1; i < A.length(); i+= 2*(B - 1)){
            sb.append(A.charAt(i));
        }
        
        return sb.toString();
    }
}
