public class Solution {
  
    
    public int atoi(final String A) {
      if (A.isEmpty()) return 0;
    int sign = 1, base = 0, i = 0;
    while (A.charAt(i) == ' ')
        i++;
    if (A.charAt(i) == '-' || A.charAt(i) == '+')
        sign = A.charAt(i++) == '-' ? -1 : 1;
    while (i < A.length() && A.charAt(i) >= '0' && A.charAt(i) <= '9') {
        if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && A.charAt(i) - '0' > 7)) {
            return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        base = 10 * base + (A.charAt(i++) - '0');
    }
    return base * sign;
       
    }
}
