public class Solution {
    public ArrayList<Integer> grayCode(int a) {
       ArrayList<Integer> res = new ArrayList<>();
       if(a == 0) return res;
       if(a == 1){
           res.add(0);
           res.add(1);
           return res;
       }
       ArrayList<Integer> firstList = grayCode(a-1);
       int len = firstList.size();
       for(int i = len - 1; i >= 0; i--){
           int num = firstList.get(i);
           int second = num + (1 << (a - 1));
           firstList.add(second);
       }
       return firstList;
    }
}
