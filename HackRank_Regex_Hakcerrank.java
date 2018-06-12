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
            p = Pattern.compile("hackerrank");
            m = p.matcher(line);
            boolean str = false, en = false;
            int count = 0;
            while(m.find()){ 
                count++;
                int start = m.start();
                if(start == 0){
                    str = true;
                }
                int end = m.end();
                if(end == line.length()){
                    en = true;
                }
            }
            if(str && en && (count == 1)){
                System.out.println(0);
            }else if(str && (count == 1)){
                System.out.println(1);
            }else if(en && (count == 1)){
                System.out.println(2);
            }else{
                System.out.println(-1);
            }
        }
    }
}
