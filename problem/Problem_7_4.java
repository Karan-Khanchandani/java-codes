package problem;/*
Problem Description:
Delete all 'b' and replace 'a' with two 'd' in string
*/


public class Problem_7_4{

    public static int replaceAndRemove(int size, char[] s){
        //remove b and count a
        int writeIdx = 0, aCount = 0;
        for(int i = 0; i< size; i++){
            if(s[i] != 'b'){
                s[writeIdx++] = s[i];
            }

            if(s[i] == 'a'){
                aCount++;
            }
        }
        int lastIdx = writeIdx + aCount - 1;
        int lastCharInd = writeIdx - 1;
        int finalSize = lastIdx+1;
        while(lastCharInd >= 0){
            if(s[lastCharInd] == 'a'){
                s[lastIdx--] = 'd';
                s[lastIdx--] = 'd';
            }else{
                s[lastIdx--] = s[lastCharInd];
                
            }
            lastCharInd--;
        }

        return finalSize;
    }

    public static void printCharArray(char[] s){
        for(int i = 0; i<s.length; i++){
            System.out.print(s[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        char[] s = {'a','c','d','b','b','c','a'};
        printCharArray(s);
        replaceAndRemove(s.length, s);
        printCharArray(s);
    }
}