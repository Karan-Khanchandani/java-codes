/* Problem Statment
The parity of a binary word is 1 if the number of Is in the word is odd; otherwise,
it is 0. For example, the parity of 1011 is 1, and the parity of 10001000 is 0. Parity
checks are used to detect single bit errors in data storage and communication. It is
fairly straightforward to write code that computes the parity of a single 64-bit word.
How would you compute the parity of a very large number of 64-bit words?
*/

import java.util.Scanner;

public class Problem_6_1_parity{

    public static short countParity(long x){
        short result = 0;
        while(x!=0){
            result ^= (x&1);
            x = x&(x-1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countParity(55));
    }
    
}