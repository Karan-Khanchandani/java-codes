public class Solution {
    public ArrayList<ArrayList<String>> partition(String a) {
    ArrayList<ArrayList<String>> lists=new ArrayList<>();
    int len=a.length();
    if(len==0) return lists;
    backtrack(lists, new ArrayList<>(), a,0,len);
    return lists;
}
private void backtrack(ArrayList<ArrayList<String>> lists,ArrayList<String> list,String s, int l, int r) {
    if(l==r) {
        lists.add(new ArrayList<>(list));
        return;
    }
    for(int i=l+1;i<=r;i++) {
        if(isPalindrome(s, l, i)) {
            list.add(s.substring(l, i));
            backtrack(lists, list, s,i,r);
            list.remove(list.size()-1);
        }
    }
}
private boolean isPalindrome(String s, int l, int r){
    if(l==r-1) return true;
    while(l<r-1){
        if(s.charAt(l)!=s.charAt(r-1)) return false;
        l++;r--;
    }
    return true;
}
    
}
