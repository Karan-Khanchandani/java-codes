import java.io.*;
import java.util.*;
import java.util.regex.*;
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Pattern p;
        Matcher m;
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for(int tno = 1; tno <= t; tno++){
            String line = sc.nextLine();
            p  = Pattern.compile("([\\d]+)[ -]([\\d]+)[ -]([\\d]+)");
            m = p.matcher(line);
            if(m.find()){
                System.out.printf("CountryCode=%s,LocalAreaCode=%s,Number=%s\n", m.group(1), m.group(2), m.group(3));
            }
        }
    }
}
