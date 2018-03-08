
/*
Paint boolean
*/
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Problem_19_2 {

    private static class Coordinate {
        public int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public static void printMatrix(List<List<Boolean>> matrix) {
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                System.out.print(matrix.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static  List<List<Boolean>> flipColor(List<List<Boolean>> golden, int x, int y) {
        Coordinate c = new Coordinate(x, y);
        Queue<Coordinate> pointsQueue = new LinkedList<>();

        final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        boolean color = golden.get(x).get(y);

        golden.get(x).set(y, !golden.get(x).get(y));
        pointsQueue.add(c);

        while (!pointsQueue.isEmpty()) {
            Coordinate currentElem = pointsQueue.element();
            for (int[] dir : DIRS) {
                Coordinate curr = new Coordinate(currentElem.x + dir[0], currentElem.y + dir[1]);
                if (curr.x >= 0 && curr.x < golden.size() && curr.y >= 0 && curr.y < golden.get(curr.x).size()
                        && golden.get(curr.x).get(curr.y) == color) {
                    //flip the color
                    golden.get(curr.x).set(curr.y, !golden.get(curr.x).get(curr.y));
                    pointsQueue.add(curr);
                }
            }
            pointsQueue.remove();
        }

        return golden;

    }

    public static void main(String[] args) {

        List<List<Boolean>> golden = new ArrayList<>(
                Arrays.asList(new ArrayList<>(Arrays.asList(false, false, false, false)),
                        new ArrayList<>(Arrays.asList(false, true, false, false))));

        printMatrix(golden);

        golden = flipColor(golden, 0, 0);
        printMatrix(golden);
    }
}