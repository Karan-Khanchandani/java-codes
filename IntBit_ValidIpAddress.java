public class Solution {
    
    static boolean isValid(String s){
        if(s.length() > 3){
            return false;
        }
        if(s.charAt(0) == '0' && s.length() == 1) return true;
        if(s.charAt(0) == '0' && s.length() > 1) return false;
        int val = Integer.parseInt(s);
        if(val <= 255) return true;
        return false;
    }
    public ArrayList<String> restoreIpAddresses(String A) {
        ArrayList<String> ans = new ArrayList<>();
        for(int i = 0; i <= 2 && i < A.length(); i++){
            if(isValid(A.substring(0,i+1))){
                for(int j = i+1; j <= i+3 && j < A.length(); j++){
                    if(isValid(A.substring(i+1, j+1))){
                        for(int k = j+1; k <= j+3 && k < A.length(); k++){
                            if(isValid(A.substring(j+1,k+1))){
                                for(int l = k+1; l <= k+3 && l < A.length(); l++){
                                    if(isValid(A.substring(k+1, A.length()))){
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(A.substring(0,i+1));
                                        sb.append('.');
                                        sb.append(A.substring(i+1, j+1));
                                        sb.append('.');
                                        sb.append(A.substring(j+1,k+1));
                                        sb.append('.');
                                        sb.append(A.substring(k+1, A.length()));
                                        
                                        String str = sb.toString();
                                        if(!ans.contains(str)){
                                            ans.add(str);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return ans;
    }
}
