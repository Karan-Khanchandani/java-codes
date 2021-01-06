package interviewbit;

public class Solution {
	// DO NOT MODIFY THE LIST
	public int repeatedNumber(final List<Integer> a) {
	    int count1 = 0, count2 = 0, n = a.size();
    int first=Integer.MAX_VALUE    , second=Integer.MAX_VALUE    ;
 
    for (int i = 0; i < n; i++) {
 
        // if this element is previously seen, 
        // increment count1.
        if (first == a.get(i).intValue())
            count1++;
 
        // if this element is previously seen, 
        // increment count2.
        else if (second == a.get(i).intValue())
            count2++;
     
        else if (count1 == 0) {
            count1++;
            first = a.get(i).intValue();
        }
 
        else if (count2 == 0) {
            count2++;
            second = a.get(i).intValue();
        }
 
        // if current element is different from
        // both the previously seen variables, 
        // decrement both the counts.
        else {
            count1--;
            count2--;
        }
    }
 
    count1 = 0;
    count2 = 0;
 
    // Again traverse the array and find the
    // actual counts.
    for (int i = 0; i < n; i++) {
        if (a.get(i).intValue() == first)
            count1++;
 
        else if (a.get(i).intValue() == second)
            count2++;
    }
 
    if (count1 > n / 3)
        return first;
 
    if (count2 > n / 3)
        return second;
 
    return -1;
	}
}
