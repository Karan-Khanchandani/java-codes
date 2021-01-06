package leetcode;

class Solution {
    public static class NumberWithCount{
        public Integer num;
        public Integer count;
        
        public NumberWithCount(Integer n, Integer c){
            this.num = n;
            this.count = c;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            if(!countMap.containsKey(nums[i])){
                countMap.put(nums[i], 1);
            }else{
                countMap.put(nums[i], countMap.get(nums[i]) + 1);
            }
        }
        
        
        PriorityQueue<NumberWithCount> pq = new PriorityQueue<>(k, new Comparator<NumberWithCount>(){
            public int compare(NumberWithCount n1, NumberWithCount n2){
                return Integer.compare(n1.count, n2.count);
            }
        });
        
        
        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()){
            pq.offer(new NumberWithCount(entry.getKey(), entry.getValue()));
            
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        while(!pq.isEmpty()){
            result.add(pq.poll().num);
        }
        
        Collections.reverse(result);
        
        return result;
        
    }
}
