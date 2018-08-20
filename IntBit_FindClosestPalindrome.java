class Solution {
    public String nearestPalindromic(String n) {
       if(n.length() == 1) return String.valueOf(Integer.parseInt(n) - 1);
        int halfLen = (n.length() + 1)/2;
        
        long half = Long.parseLong(n.substring(0, halfLen));
        List<Long> candidates = new ArrayList<>();
        candidates.add(getAllNines(n.length()));
        candidates.add(getAllNines(n.length() - 1));
        candidates.add(getAllOnes(n.length() + 1));
        candidates.add(getAllOnes(n.length()));
        
        getcandidates(candidates,half,n.length());
        Collections.sort(candidates);
        long dif = Long.MAX_VALUE;
        long r = Long.parseLong(n);
        String res = "";
        for(Long ele:candidates){
             if(ele == r){
                 continue;
             }
             if(dif>Math.abs(ele-r)){
                 dif = Math.abs(ele-r);
                 res = String.valueOf(ele);
             }
         }
         return res;
    }
    
    public void getcandidates(List<Long> ans,long m,int len){
        List<Long> reg = new ArrayList<>();
        reg.add(m);
        reg.add(m-1);
        reg.add(m+1);
        for(Long ele : reg){
            if(len%2==0){
              String str = String.valueOf(ele);
              str+=new StringBuilder(str).reverse().toString();
              ans.add(Long.parseLong(str));
           }else{
               String str = String.valueOf(ele);
               StringBuilder sb = new StringBuilder(str.substring(0,str.length()-1));
               str = str + sb.reverse().toString();
               ans.add(Long.parseLong(str));
            }
        }
    }
    
    public Long getAllNines(int n){
        String s = "";
        for(int i = 0; i < n; i++) s += "9";
        return Long.parseLong(s);
    }
    
    public Long getAllOnes(int n){
        return (long)Math.pow(10, n - 1) + 1;
    }
}
