package interviewbit;

public class Solution {
    private class Pair{
    int x ; int y ;
    }
    ArrayList<Integer> xindex ; ArrayList<Integer> yindex ; int R ;int len ;
    public String solve(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
        int dp[][] = new int[A+1][B+1] ;
        len = E.size() ;
        for(int i=0;i<=A;i++)
        {
            for(int j=0;j<=B;j++)
            dp[i][j] = -1 ;
        }
    
        xindex = E ; yindex = F ;
        dp[0][0] = 1 ; R = D*D ;
        LinkedList<Pair> q = new LinkedList<Pair>() ;
        Pair obj = new Pair() ;
        obj.x = 0 ; obj.y = 0 ;
        q.add(obj) ;
        int arr1[] = {1,1,1,0,-1,-1,-1,0} ;
        int arr2[] = {-1,0,1,1,1,0,-1,-1} ;

        while(q.size()!=0)
        {
            Pair temp = q.poll() ;
            int x1 = temp.x ;
            int x2 = temp.y ;
    
            for(int i=0;i<8;i++)
            {
                int t1 = x1+arr1[i] ; int t2 = x2+arr2[i] ;
    
                if((t1>=0)&&(t1<=A)&&(t2>=0)&&(t2<=B))
                {
                    if(dp[t1][t2]==-1)
                    {
                        boolean res = isValidIndex(t1,t2) ;
                        if(res==false)
                        dp[t1][t2] = 2 ;
                        else
                        {
                            dp[t1][t2] = 1 ;
                            Pair t = new Pair() ;
                            t.x = t1 ; 
                            t.y = t2 ;
                            q.add(t) ;
                        }
                    }
                }
            }
    
            if(dp[A][B]!=-1)
            break ;
        }
    
        if(dp[A][B]==1)
        return "YES" ;
    
        return "NO" ;

}

public boolean isValidIndex(int x,int y){
    for(int i=0;i<len;i++){
            int x1 = xindex.get(i) ; int x2 = yindex.get(i) ;
            if((x==x1)&&(y==x2))
            return false ;
    
            int n = (x1-x)*(x1-x) + (x2-y)*(x2-y) ;
    
            if(n<=R)
            return false ;
        }
    return true ;
    }
}
