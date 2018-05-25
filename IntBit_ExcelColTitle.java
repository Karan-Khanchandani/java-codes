public class Solution {
    public String convertToTitle(int A) {
        StringBuilder sb = new StringBuilder();
        while(A > 0){
            A = A - 1;
            char c = (char)('A' + A%26);
            sb.append(c);
            A = A/26;
            
        }
        return sb.reverse().toString();
    }
}
