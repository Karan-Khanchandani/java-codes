package interviewbit;

public class Solution {
    static int addString(String a, char[] s, int idx, int startIdx, int endIdx) {
        if (startIdx < 0) return idx;
        for (int i = startIdx; i <= endIdx; i++)
            s[idx++] = a.charAt(i);
        s[idx++] = ' ';
        return idx;
    }

    public String reverseWords(String a) {
        if (a.length() == 1 && a.equals(" ")) return "";
        if (a.length() == 1) return a;
        char[] s = new char[a.length() + 1];
        int k = 0;
        int i = a.length() - 1, j = a.length() - 1;
        while (i >= 0) {
            while (i >= 0 && j >= 0 && a.charAt(i) == ' ') i--;
            j = i;
            if (i < 0) break;
            while (j >= 0 && i >= 0 && a.charAt(j) != ' ') j--;
            k = addString(a, s, k, j + 1, i);
            i = j;
        }
        --k;
        StringBuilder sb = new StringBuilder();
        for (i = 0; i < k; i++) sb.append(s[i]);

        return sb.toString();
    }
}
