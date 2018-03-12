import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
PRoblem Description:
Print matrix in spiral order
*/

public class Problem_6_17 {

    public static List<Integer> spiralMatrix(List<List<Integer>> matrix) {
        List<Integer> spiral_matrix = new ArrayList<>();
        final int SHIFT[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int dir = 0, x = 0, y = 0;
        for (int i = 0; i < matrix.size() * matrix.size(); i++) {

            spiral_matrix.add(matrix.get(x).get(y));
            matrix.get(x).set(y, 0);

            int nextX = x + SHIFT[dir][0];
            int nextY = y + SHIFT[dir][1];

            if (nextX < 0 || nextX >= matrix.size() || nextY < 0 || nextY >= matrix.size()
                    || matrix.get(nextX).get(nextY) == 0) {
                dir = (dir + 1) % 4;
                nextX = x + SHIFT[dir][0];
                nextY = y + SHIFT[dir][1];
            }

            x = nextX;
            y = nextY;
        }

        return spiral_matrix;
    }

    public static void printList(List<Integer> list) {
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        matrix.add(new ArrayList<>(Arrays.asList(4, 5, 6)));
        matrix.add(new ArrayList<>(Arrays.asList(7, 8, 9)));

        List<Integer> spiral_matrix = spiralMatrix(matrix);
        printList(spiral_matrix);
    }

}