package leetcode;

class LeetCode_6 {
    public String convert(String s, int numRows) {
        
        if(s.equals("") || s == null){
            return s;
        }
        
        if(numRows == 1){
            return s;
        }
        if(numRows == 2){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < s.length(); i+=2){
                sb.append(s.charAt(i));
            }
            
            for(int i = 1; i < s.length(); i+=2){
                sb.append(s.charAt(i));
            }
            
            return sb.toString();
        }
        
        //more than 2 rows
        StringBuilder sb = new StringBuilder();
        //append first row
        for(int i = 0; i < s.length(); i+= 2*(numRows - 1)){
            sb.append(s.charAt(i));
        }
        
        //do something
        for(int i = 1; i < numRows - 1; i++){
            for(int j = i; j < s.length(); j+= 2*(numRows - 1)){
                sb.append(s.charAt(j));
                int k = j + 2*(numRows - 1 - i);
                if(k < s.length()){
                    sb.append(s.charAt(k));
                }
            }
            
        }
        
        //last row
        for(int i = numRows - 1; i < s.length(); i+= 2*(numRows - 1)){
            sb.append(s.charAt(i));
        }
        
        return sb.toString();
        
    }
}
