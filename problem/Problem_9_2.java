package problem;

import java.util.Deque;
import java.util.LinkedList;

/*
Problem Descriptio: Arithmetic operation on RPN String 1,2,*
*/

public class Problem_9_2{
    public static int eval(String RPNExpression){
        Deque<Integer> intermediateResults = new LinkedList<>();
        String delimiter = ",";
        String[] symbols = RPNExpression.split(delimiter);
        
        for(String token: symbols){
            if(token.length() == 1 && "+-*/".contains(token)){
                final int x = intermediateResults.removeFirst();
                final int y = intermediateResults.removeFirst();

                switch(token.charAt(0)){
                    case '+':
                        intermediateResults.addFirst(x + y);
                        break;
                    case '-':
                        intermediateResults.addFirst(x - y);
                        break;
                    case '*':
                        intermediateResults.addFirst(x * y);
                        break;
                    case '/':
                        intermediateResults.addFirst(x / y);
                        break;
                    default :
                        throw new IllegalArgumentException("Malformed RPN at :" + token);
                }
            }else{
                intermediateResults.addFirst(Integer.parseInt(token));
            }
        }

        return intermediateResults.removeFirst();
    }

    public static void main(String[] args) {
        System.out.println(eval("3,4,+,2,*,1,+"));
    }
}