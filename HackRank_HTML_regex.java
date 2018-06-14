import java.io.*;
import java.util.*;
import java.util.regex.*;
public class HackRank_HTML_regex {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int n;
        Matcher mat;
        Pattern pat;
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        for(int tno = 1; tno <= n; tno++){
            String line = sc.nextLine();
           // String p = "[<]a.*[>](.*)[<].*a[>]";
           String p = "(href=\")(\\.*)\"";
           StringBuilder sb = new StringBuilder();
           pat = Pattern.compile(p);
           mat = pat.matcher(line);
           if(mat.find()){
               sb.append(mat.group(1).trim());
           }
           sb.append(',');
            p = "[<]a.*[>](.*)[<].*a[>]";
            pat = Pattern.compile(p);
            mat = pat.matcher(line);
            if(mat.find()){
                sb.append(mat.group(1).trim());
            }
            System.out.println(sb.toString());
        }
    }
}