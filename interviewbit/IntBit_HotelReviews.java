package interviewbit;

public class Solution {
    public ArrayList<Integer> solve(String A, ArrayList<String> B) {
        HashMap<Integer, ArrayList<Integer>> reviewOrder = new HashMap<>();
        HashSet<String> goodWords = new HashSet<>();
        String[] good = A.split("_");
        for (int i = 0; i < good.length; i++) {
            goodWords.add(good[i]);
        }

        for (int i = 0; i < B.size(); i++) {
            String review = B.get(i);
            String[] reviewWords = review.split("_");
            int goodCount = 0;
            for (int j = 0; j < reviewWords.length; j++) {
                if (goodWords.contains(reviewWords[j])) {
                    goodCount++;
                }
            }

            if (reviewOrder.containsKey(goodCount)) {
                reviewOrder.get(goodCount).add(i);
            } else {
                ArrayList<Integer> ss = new ArrayList<>();
                ss.add(i);
                reviewOrder.put(goodCount, ss);
            }
        }

        ArrayList<Integer> keys = new ArrayList<Integer>(reviewOrder.keySet());
        Collections.sort(keys, Collections.reverseOrder());

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < keys.size(); i++) {
            ArrayList<Integer> temp = reviewOrder.get(keys.get(i));
            ans.addAll(temp);
        }

        return ans;

    }
}
