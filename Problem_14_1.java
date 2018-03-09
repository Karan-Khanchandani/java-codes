import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
Problem Description:
Implement Tower of Hanoi using recursion
*/

public class Problem_14_1 {

    public static final int NUM_OF_PEGS = 3;

    public static void TowerOfHanoi(int n) {
        //from to use
        List<Deque<Integer>> pegs = new ArrayList<>();

        for (int i = 0; i < NUM_OF_PEGS; i++) {
            pegs.add(new LinkedList<>());
        }
        for (int i = n; i >= 0; i--) {
            pegs.get(0).addFirst(i);
        }
        TowerOfHanoiHelper(n, pegs, 0, 1, 2);
    }

    public static void TowerOfHanoiHelper(int n, List<Deque<Integer>> pegs, int from, int to, int use) {
        if (n > 0) {
            TowerOfHanoiHelper(n - 1, pegs, from, use, to);
            pegs.get(to).addFirst(pegs.get(from).removeFirst());
            System.out.println("Move from peg " + from + " to peg " + to);
            TowerOfHanoiHelper(n - 1, pegs, use, to, from);
        }
    }

    public static void main(String[] args) {
        TowerOfHanoi(3);
    }
}