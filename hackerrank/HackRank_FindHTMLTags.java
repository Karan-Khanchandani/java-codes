package hackerrank;

import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HackRank_FindHTMLTags {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named hackerrank.Solution. */
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
