package interviewbit;

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> findSubstring(String A, final List<String> B) {
        HashMap<String, Integer> counts = new HashMap<>();
        for (final String word : B) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        ArrayList<Integer> indices = new ArrayList<>();
        if (B.size() == 0) return indices;
        int n = A.length(), num = B.size(), len = B.get(0).length();
        for (int i = 0; i < n - num * len + 1; i++) {
            HashMap<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < num) {
                String word = A.substring(i + j * len, i + (j + 1) * len);
                if (counts.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    if (seen.get(word) > counts.getOrDefault(word, 0)) {
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
            if (j == num) {
                indices.add(i);
            }
        }
        return indices;
    }
}
