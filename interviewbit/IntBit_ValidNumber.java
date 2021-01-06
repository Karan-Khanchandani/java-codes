package interviewbit;

import java.util.regex.*;
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int isNumber(final String A) {
        Pattern p;
        Matcher m;
        p = Pattern.compile("^[ ]*[-]?[\\d]*([.][\\d]+)?[e]?[-]?[\\d]+[ ]*$");
        m = p.matcher(A);
        if(m.find()) return 1;
        
        p = Pattern.compile("^[ ]*[-]?[\\d]*[.]?[\\d]+[ ]*$");
        m = p.matcher(A);
        if(m.find()) return 1;
        
        return 0;
    }
}
