package leetcode;

class Solution {
    public int maxProfit(int[] prices) {
        
        if(prices == null || prices.length == 0){
            return 0;
        }
        
        //extra space is not needed here
        int min_till[] = new int[prices.length];
        min_till[0] = prices[0];
        int minElem = prices[0];
        
        for(int i = 1 ; i < prices.length; i++){
            min_till[i] = minElem;
            if(minElem > prices[i]){
                minElem = prices[i];
            }
        }
        
        int maxProfit = 0;
        for(int i = 0; i < min_till.length; i++){
            maxProfit = Math.max(maxProfit, prices[i] - min_till[i]);
        }
        
        return maxProfit;
    }
}
