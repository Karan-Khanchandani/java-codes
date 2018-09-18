public class Solution {
    public String longestCommonPrefix(ArrayList<String> A) {
        if(A.size()==0) return "";
        String minStr=A.get(0);
        
        for(int i=1;i<A.size();i++){
            if(A.get(i).length()<minStr.length())
                minStr=A.get(i);
        }
        int end=minStr.length();
        for(int i=0;i<A.size();i++){
            int j;
            for( j=0;j<end;j++){
                if(minStr.charAt(j)!=A.get(i).charAt(j))
                    break;
            }
            if(j<end)
                end=j;
        }
        return minStr.substring(0,end);
    }
}
