public class Solution {
    public String addBinary(String A, String B) {
        int i = A.length() - 1, j = B.length() - 1;
        StringBuilder sb = new StringBuilder();
        char carry = '0';
        while(i >= 0 && j >= 0){
            if(A.charAt(i) == '0' && B.charAt(j) == '0' && carry == '0'){
                sb.append('0');
                carry = '0';
            }else if(A.charAt(i) == '0' && B.charAt(j) == '0' && carry == '1'){
                sb.append('1');
                carry = '0';
            }else if(A.charAt(i) == '0' && B.charAt(j) == '1' && carry == '0'){
                sb.append('1');
                carry = '0';
            }else if(A.charAt(i) == '0' && B.charAt(j) == '1' && carry == '1'){
                sb.append('0');
                carry = '1';
            }else if(A.charAt(i) == '1' && B.charAt(j) == '0' && carry == '0'){
                sb.append('1');
                carry = '0';
            }else if(A.charAt(i) == '1' && B.charAt(j) == '0' && carry == '1'){
                sb.append('0');
                carry = '1';
            }else if(A.charAt(i) == '1' && B.charAt(j) == '1' && carry == '0'){
                sb.append('0');
                carry = '1';
            }else{
                sb.append('1');
                carry = '1';
            }
            i--; j--;
        }
        while(i >= 0){
            if(A.charAt(i) == '0'  && carry == '0'){
                sb.append('0');
                carry = '0';
            }else if(A.charAt(i) == '0' && carry == '1'){
                sb.append('1');
                carry = '0';
            }else if(A.charAt(i) == '1' && carry == '0'){
                sb.append('1');
                carry = '0';
            }else{
                sb.append('0');
                carry = '1';
            }
            i--;
        }
        
        while(j >= 0){
            if(B.charAt(j) == '0'  && carry == '0'){
                sb.append('0');
                carry = '0';
            }else if(B.charAt(j) == '0' && carry == '1'){
                sb.append('1');
                carry = '0';
            }else if(B.charAt(j) == '1' && carry == '0'){
                sb.append('1');
                carry = '0';
            }else{
                sb.append('0');
                carry = '1';
            }
            j--;
        }
        
        if(carry == '1') sb.append('1');
        carry = '0';
        return sb.reverse().toString();
    }
}
