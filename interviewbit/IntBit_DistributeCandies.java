package interviewbit;

public class Solution {
    public int candy(ArrayList<Integer> A) {
        int size=A.size();
         if(size<=1)
             return size;
         int num[] = new int[size];
         Arrays.fill(num, 1);
         for (int i = 1; i < size; i++)
         {
             if(A.get(i)>A.get(i-1))
                 num[i]=num[i-1]+1;
         }
         for (int i= size-1; i>0 ; i--)
         {
             if(A.get(i-1)>A.get(i))
                 num[i-1]=Math.max(num[i]+1,num[i-1]);
         }
         int result=0;
         for (int i = 0; i < size; i++)
         {
             result+=num[i];
         }
         return result;
    }
}
