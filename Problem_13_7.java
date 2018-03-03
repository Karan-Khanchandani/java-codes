import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
Problem Description:
Find the smallest substring in paragraph that covers all keywords
*/

public class Problem_13_7 {

    private static class Subarray {
        public int start;
        public int end;

        public Subarray(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static Subarray findMinWindow(List<String> paragraph, List<String> keywords) {
        //create a Hash of keywords with count
        Subarray result = new Subarray(-1, -1);
        HashMap<String, Integer> keywordsMap = new HashMap<>();
        for (String s : keywords) {
            if (!keywordsMap.containsKey(s)) {
                keywordsMap.put(s, 1);
            } else {
                keywordsMap.put(s, keywordsMap.get(s) + 1);
            }
        }

        int keywordSoFar = 0;
        int remainingKeyWords = keywords.size();

        for (int right = 0, left = 0; right < paragraph.size(); right++) {
            String paraWord = paragraph.get(right);
            Integer keyword = keywordsMap.get(paraWord);

            if (keyword != null) {
                keywordsMap.put(paraWord, --keyword);
                if (keyword >= 0) {
                    remainingKeyWords--;
                }
            }

            while (remainingKeyWords == 0) {
                if ((result.start == -1 && result.end == -1) || (right - left < result.end - result.start)) {
                    result.start = left;
                    result.end = right;
                }

                paraWord = paragraph.get(left);

                keyword = keywordsMap.get(paraWord);

                if (keyword != null) {
                    keywordsMap.put(paraWord, ++keyword);
                    if (keyword > 0) {
                        remainingKeyWords++;
                    }
                }

                left++;
            }

        }

        return result;
    }

    public static void main(String[] args) {

        String para = "This is a paragraph hello world shut up i want to do work save the union save the save union save hello the union save end end ned";
        String keyw = "save union save";
        List<String> paragraph = new ArrayList<String>(Arrays.asList(para.split(" ")));
        List<String> keywords = new ArrayList<String>(Arrays.asList(keyw.split(" ")));

        Subarray  result = findMinWindow(paragraph, keywords);

        System.out.println(result.start + " .. " + result.end);
    }
}