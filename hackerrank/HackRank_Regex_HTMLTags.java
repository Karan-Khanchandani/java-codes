package hackerrank;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class HackRank_Regex_HTMLTags {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named hackerrank.Solution. */
        Scanner sc = new Scanner(System.in);
        Pattern p;
        Matcher m;
        StringBuilder sb = new StringBuilder();
        while(sc.hasNextLine()){
            sb.append(sc.nextLine());
            sb.append(' ');
        }
        String text = sb.toString();
        p = Pattern.compile(".question-summary-(\\w*).*?question-hyperlink\"[>](.+?)\\<\\/a\\>.*?class=\"relativetime\"\\>(.+?)\\<\\/span\\>");
        
       m = p.matcher(text);
        while(m.find()){
            String q = m.group(1).trim();
             String t = m.group(2).trim();
            String a = m.group(3).trim();
            System.out.println(q + ";" + t + ";"+a );       
        }
        
    }
}