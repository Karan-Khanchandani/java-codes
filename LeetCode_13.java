class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            char prev = s.charAt(i);
            char next = (i+1 < s.length()) ? s.charAt(i+1) : ' ';
            if(prev == 'I' && next == 'V'){
                ans += 4;
                i++;
            }else if(prev == 'I' && next == 'X'){
                ans += 9;
                i++;
            }else if(prev == 'X' && next == 'L'){
                ans += 40;
                i++;
            }else if(prev == 'X' && next == 'C'){
                ans += 90;
                i++;
            }else if(prev == 'C' && next == 'D'){
                ans += 400;
                i++;
            }else if(prev == 'C' && next == 'M'){
                ans += 900;
                i++;
            }else if(prev == 'I'){
                ans += 1;
            }else if(prev == 'V'){
                ans += 5;
            }else if(prev == 'X'){
                ans += 10;
            }else if(prev == 'L'){
                ans += 50;
            }else if(prev == 'C'){
                ans += 100;
            }else if(prev == 'D'){
                ans += 500;
            }else if(prev == 'M'){
                ans += 1000;
            }else{
                ans += 0;
            }
        }
        return ans;
    }
}
