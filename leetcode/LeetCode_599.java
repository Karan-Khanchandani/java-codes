package leetcode;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < list1.length; i++){
            map.put(list1[i],i);
        }
        int min = Integer.MAX_VALUE;
        List<String> res = new ArrayList<>();
        for(int i = 0; i < list2.length; i++){
            if(map.containsKey(list2[i])){
                
                Integer idx = map.get(list2[i]);
                if(min > i + idx){
                    res.clear();
                    res.add(list2[i]);
                    min = i + idx;
                    
                }else if(min == i + idx){
                    res.add(list2[i]);
                }
            }
        }
        
        String[] ans = new String[res.size()];
        for(int i = 0; i < res.size(); i++){
            ans[i] = res.get(i);
        }
        
        return ans;
    }
}
