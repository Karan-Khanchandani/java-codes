package interviewbit;

public class Solution {
    public ArrayList<String> prettyJSON(String A) {
        ArrayList<String> result = new ArrayList<String>();
        int indentation = 0;
        String temp = "";
        String a = A;
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (c == ' ')
                continue;
            else if (c == '[' || c == '{') {
                temp += c;
                for (int j = indentation; j > 0; j--)
                    temp = "\t" + temp;

                result.add(temp);
                temp = "";
                indentation++;
            } else if (c == ']' || c == '}') {
                if (i < a.length() - 1 && a.charAt(i + 1) == ',') {
                    temp += c;
                    temp += a.charAt(++i);
                    indentation--;

                    for (int j = indentation; j > 0; j--)
                        temp = "\t" + temp;

                    result.add(temp);
                    temp = "";
                } else {
                    temp += c;
                    indentation--;
                    for (int j = indentation; j > 0; j--)
                        temp = "\t" + temp;

                    result.add(temp);
                    temp = "";
                }
            } else if (c == ':' && (a.charAt(i + 1) == '{' || a.charAt(i + 1) == '[')) {
                temp = temp + c;
                for (int j = indentation; j > 0; j--)
                    temp = "\t" + temp;

                result.add(temp);
                temp = "";
            } else if (c == ':' && (a.charAt(i + 1) != '{' || a.charAt(i + 1) != '['))
                temp = temp + c;

            else if (c == ',' || c == ':' || a.charAt(i + 1) == '}' || a.charAt(i + 1) == ']' || a.charAt(i + 1) == '{' || a.charAt(i + 1) == '[') {
                temp = temp + c;

                for (int j = indentation; j > 0; j--)
                    temp = "\t" + temp;

                result.add(temp);
                temp = "";
            } else {
                temp = temp + c;
            }
        }
        return result;
    }
}
