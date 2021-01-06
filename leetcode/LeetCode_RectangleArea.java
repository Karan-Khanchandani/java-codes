package leetcode;

class LeetCode_RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        //x-bottom intersect when bottom left of one rect is lies between bleft-x  than top right-x of another
        //y-bottom intersect when bottome left y of one rect lies between bleft-y and top-right y of other
        //x-top inter will be the edge of the leftmost 
        int xb = 0, yb = 0, xt = 0, yt= 0;
        if(A >= E && A <= G){
            xb = A;
        }
        if(E >= A && E <= C){
            xb = E;
        }
        
        if(B >= F && B <= H){
            yb = B;
        }
        if(F >= B && F <= D){
            yb = F;
        }
        
        if(C >= E && C <= G){
            xt = C;
        }
        if(G >= A && G <= C){
            xt = G;
        }
        
        if(D >= F && D <= H){
            yt = D;
        }
        if(H >= B && H <= D){
            yt = H;
        }
        
        int overlapArea = Math.abs(xt-xb)*Math.abs(yt-yb);
        int area1 = (C - A)*(D - B);
        int area2 = (G- E)*(H -F);
        return area1 + area2 - overlapArea;
        
         
    }
}
