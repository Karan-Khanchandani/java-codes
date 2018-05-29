public class Solution {
	public int pow(int x, int n, int d) {
	    if(x == 0 || x == 1) return x;
	    if(n == 0) return 1;
	    long res = 1; 
	    long _x = (long) x;
	    long _d = (long) d;
	    long _n = (long) n;// Initialize result
 
    _x = _x % d;  
    while (_n > 0)
    {
        if ((_n & 1) > 0){
             res = ((res%_d)*(_x%_d));
             res = res%_d;
        }
        _n = _n>>1; // y = y/
        _x = (_x%_d)*(_x%_d);
        _x = _x%_d;  
    }
    if(res < 0) res = (res + _d)%_d;
    int an = Integer.parseInt(String.valueOf(res));
    return an%d;
	}
}
