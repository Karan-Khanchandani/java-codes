package interviewbit;

public class Solution {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int carry = 1;
        int i = 0;
        while (!A.isEmpty() && A.get(i) == 0) {
            A.remove(i);
        }

        for (i = A.size() - 1; i >= 0; i--) {
            int sum = (A.get(i) + carry);
            carry = sum / 10;
            A.set(i, sum % 10);
        }
        //first remove the msb zeros
        if (carry > 0) {
            A.add(0, carry);
        }


        return A;
    }
}
