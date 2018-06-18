public class Solution {
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        int n = A.size();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i).intValue() < A.get(i - 1).intValue())
                flag = true;
            if (flag)
                min = Math.min(min, A.get(i).intValue());
        }
        flag = false;
        for (int i = A.size() - 2; i >= 0; i--) {
            if (A.get(i).intValue() > A.get(i + 1).intValue())
                flag = true;
            if (flag)
                max = Math.max(max, A.get(i).intValue());
        }
        int l, r;
        for (l = 0; l < A.size(); l++) {
            if (min < A.get(l).intValue())
                break;
        }
        for (r = A.size() - 1; r >= 0; r--) {
            if (max > A.get(r).intValue())
                break;
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        if(r - l == A.size() || r < 0 || l >= A.size()){
            res.add(-1);
            return res;
        }
        res.add(l);
        res.add(r);
        return res;
    }
}
