package leetcode;

class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        
        Map<String, List<String>> groups = new HashMap<String, List<String>>();
        
        for (String s : strings) {
            int shift = 'z' - s.charAt(0);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                sb.append((s.charAt(i) + shift) % 26);
            }
            if (!groups.containsKey(sb.toString())) {
                groups.put(sb.toString(), new ArrayList<String>());
            }
            groups.get(sb.toString()).add(s);
        }
        
        return new ArrayList<List<String>>(groups.values());
        
    }
}
