class Solution {
    public List<Integer> grayCode(int n) {

        if(n == 0){
            List<Integer> ans = new ArrayList<>();
            ans.add(0);
            return ans;
        }
        
        List<Integer> firstHalf = grayCode(n - 1);
        
        List<Integer> ans = new ArrayList<>(firstHalf);
        List<Integer> secondHalf = firstHalf;
        Collections.reverse(secondHalf);
        
        for(int i : secondHalf){
            ans.add(i + (1 << (n - 1)));
        }
        
        return ans;
    }
}
