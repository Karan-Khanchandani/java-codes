class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s.equals("") && t.equals("")){
            return false;
        }
        if(Math.abs(s.length() - t.length()) > 1){
            return false;
        }
        
        if(Math.abs(s.length() - t.length()) == 1){
            //insert or delete
            boolean first = false;
            if(s.length() < t.length()){
                for(int i = 0, j= 0; i < s.length(); ){
                    if(s.charAt(i) == t.charAt(j)){
                        i++;
                        j++;
                    }else{
                        if(!first){
                            first = true;
                            j++;
                        }else{
                            return false;
                        }
                    }
                }
            }else{
                for(int i = 0, j= 0; i < t.length(); ){
                    if(t.charAt(i) == s.charAt(j)){
                        i++;
                        j++;
                    }else{
                        if(!first){
                            first = true;
                            j++;
                        }else{
                            return false;
                        }
                    }
                }
            }
            
            return true;
        }
            //all chars are same
            //see if there is diff of one char
            int diff = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) != t.charAt(i)){
                    diff++;
                }
                if(diff > 1){
                    return false;
                }
            }
            if(diff == 1)
            return true;
        
        return false;
    }
}
