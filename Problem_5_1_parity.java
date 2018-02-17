/* Problem Statment
The parity of a binary word is 1 if the number of Is in the word is odd; otherwise,
it is 0. For example, the parity of 1011 is 1, and the parity of 10001000 is 0. Parity
checks are used to detect single bit errors in data storage and communication. It is
fairly straightforward to write code that computes the parity of a single 64-bit word.
How would you compute the parity of a very large number of 64-bit words?
*/

import java.util.Scanner;

public class Problem_5_1_parity{

    public static short cp(long x){
        x ^= (x >> 16);
        x ^= (x >> 8);
        x ^= (x >> 4);
        x ^= (x >> 2);
        x ^= (x >> 1);

        return (short)(x & 0x1);
    }

    public static short countParity(long x){
        final int WORD_SIZE = 16;
        final int BIT_MASK = 0xFFFF;

        int preComputeParity[] = new int[1<<16];
        for( int i = 0; i < 1<<16; i++){
            preComputeParity[i] = cp(i);
        }


        return (short) (preComputeParity[(int) ((x >>> (3*WORD_SIZE)) & BIT_MASK)] ^ preComputeParity[(int) ((x >>> (2*WORD_SIZE)) & BIT_MASK)]
        ^ preComputeParity[(int) ((x >>> (1*WORD_SIZE)) & BIT_MASK)] ^ preComputeParity[(int) (x & BIT_MASK)]);
    }

    public static void main(String[] args) {
        System.out.println(countParity(3));
    }
    
}