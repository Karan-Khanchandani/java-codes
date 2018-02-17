/*
Problem Description
Write a program that takes a 64-bit word and returns the 64-bit word consisting of
the bits of the input word in reverse order. For example, if the input is alternating Is
and Os, i.e., (1010 ... 10), the output should be alternating Os and Is, i.e., (0101 ... 01).
*/

public class Problem_5_3 {

    private static final int WORD_SIZE = 16;
    private static   final int LOOKUP_SIZE = 1<<16;
    private static   final int BIT_MASK = 0xFFFF;
    private static  long preComputedReverse[] = new long[LOOKUP_SIZE];
    public static long swapBits(long x, int i, int j) {
        if (((x >>> i) & 1) != ((x >>> j) & 1)) {
            long bitmask = (1L << i) | (1L << j);
            x ^= bitmask;
        }
        return x;
    }

    public static long reverse(long x, int n) {
        for(int i = 0, j = n; i < j; i++, j--){
            x = swapBits(x, i , j);
        }
        return x;
    }

    private static void createPrecomputedTable(){
          
        for( int i = 0; i< LOOKUP_SIZE; i++){
            preComputedReverse[i] = reverse(i,15);
        }
    }

    public static long reverseBits(long x) {
      
        return (
            preComputedReverse[(int)(x & BIT_MASK)] << 3*WORD_SIZE |
            preComputedReverse[(int)((x >>> WORD_SIZE) & BIT_MASK)] << 2*WORD_SIZE |
            preComputedReverse[(int)((x >>> 2*WORD_SIZE) & BIT_MASK)] << WORD_SIZE |
            preComputedReverse[(int)((x >>> 3*WORD_SIZE) & BIT_MASK)] 
        );
    }

    public static void main(String[] args) {
        createPrecomputedTable();
        System.out.println(swapBits(11, 1, 2));
        System.out.println(reverse(14, 3));
        System.out.println(reverseBits(1));
        System.out.println(reverse(1, 63));
    }
}