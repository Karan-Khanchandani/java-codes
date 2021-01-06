package interviewbit;

public class Solution {
    public int countInversions(ArrayList<Integer> A) {
        int ans = mergeSort(A, 0 , A.size() - 1);
        return ans;
    }
    
    public int mergeSort(ArrayList<Integer> A, int start, int end){
        if(start >= end) return 0;
        
        int invCount = 0;
        int mid = start + (end - start)/2;
        
        invCount += mergeSort(A, start, mid);
        invCount += mergeSort(A, mid+1, end);
        invCount += merge(A, start, mid+1, end);
        
        return invCount;
    }
    
    public int merge(ArrayList<Integer> A, int start, int mid, int end){
        int[] temp = new int[A.size()];
        int invCount = 0;
        int i = start, j = mid, k = start;
        
        while(i <= mid-1 && j <= end){
            if(A.get(i) <= A.get(j)){
                temp[k++] = A.get(i);
                i++;
            }else{
                temp[k++] = A.get(j);
                invCount += (mid - i);
                j++;
            }
        }
        
        while(i <= mid - 1){
             temp[k++] = A.get(i);
                i++;
        }
        while(j <= end){
            temp[k++] = A.get(j);
            j++;
        }
        
        for(i = start; i <= end; i++){
            A.set(i, temp[i]);
        }
        
        return invCount;
    }
}
