package interviewbit;

public class Solution {
    public int maxp3(ArrayList<Integer> A) {
        //ans would be two negs * highest or highest * next two
        Collections.sort(A);
        return Math.max(A.get(0)*A.get(1)*A.get(A.size() -1),A.get(A.size() - 3)*A.get(A.size() - 2)*A.get(A.size() -1)); 
    }
}
