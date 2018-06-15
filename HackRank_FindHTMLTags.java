import java.io.*;
import java.util.*;
import java.util.regex.*;
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        //<\\b(\\w+)\\b.*?>
        int n;
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++){
            sb.append(sc.nextLine());
            sb.append(" ");
        }
        SortedSet<String> res = new TreeSet<String>();
        Pattern p = Pattern.compile("<\\b(\\w+)\\b.*?>");
        Matcher m = p.matcher(sb.toString());
        while(m.find()){
            res.add(m.group(1));
        }
        sb = new StringBuilder();
        Iterator it = res.iterator();
        while(it.hasNext()){
            sb.append(it.next());
            sb.append(";");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}
