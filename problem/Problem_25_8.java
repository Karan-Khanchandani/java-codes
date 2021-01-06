package problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem Description:
Justify texts
*/

public class Problem_25_8 {

    public static List<String> justify_text(List<String> strings, int L) {
        List<String> result = new ArrayList<>();

        int currentLineStart = 0, currentLineLenght = 0, numWordsCurrentLine = 0;

        for (int i = 0; i < strings.size(); i++) {
            ++numWordsCurrentLine;

            int lookAheadLineLenght = currentLineLenght + strings.get(i).length() + (numWordsCurrentLine - 1);

            if (lookAheadLineLenght == L) {
                result.add(joinLineWithSpaces(strings, currentLineStart, i, i - currentLineStart));
                currentLineLenght = 0;
                numWordsCurrentLine = 0;
                currentLineStart = i + 1;
            } else if (lookAheadLineLenght > L) {
                result.add(joinLineWithSpaces(strings, currentLineStart, i - 1, L - currentLineLenght));
                currentLineStart = i;
                numWordsCurrentLine = 1;
                currentLineLenght = strings.get(i).length();
            } else {
                currentLineLenght += strings.get(i).length();
            }

        }

        if (numWordsCurrentLine > 0) {
            StringBuilder line = new StringBuilder(
                    joinLineWithSpaces(strings, currentLineStart, strings.size() - 1, numWordsCurrentLine - 1));
            for (int i = 0; i < (L - currentLineLenght - (numWordsCurrentLine - 1)); i++) {
                line.append(' ');
            }
            result.add(line.toString());
        }
        return result;
    }

    public static String joinLineWithSpaces(List<String> strings, int startIndex, int endIndex, int numSpaces) {
        int currentWords = endIndex - startIndex + 1;
        StringBuilder line = new StringBuilder();

        for (int i = startIndex; i < endIndex; i++) {
            line.append(strings.get(i));
            currentWords--;
            int numCurrSpace = (int) Math.ceil((double) numSpaces / currentWords);
            for (int j = 0; j < numCurrSpace; j++) {
                line.append(' ');
            }
            numSpaces -= numCurrSpace;
        }
        line.append(strings.get(endIndex));
        for (int i = 0; i < numSpaces; i++) {
            line.append(' ');
        }
        return line.toString();
    }

    public static void printList(List<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {

        List<String> strings = new ArrayList<>(
                Arrays.asList("The", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dogs."));

        List<String> result = justify_text(strings, 11);

        printList(result);

        List<String> strings2 = new ArrayList<>(Arrays.asList("Karan", "is", "a", "good", "boy", "hellosadsdsadasfdgfasf"));

        result = justify_text(strings2, 25);

        printList(result);

    }
}