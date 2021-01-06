package problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Arrays;

/*
Problem Description:

Search in maze
*/

public class Problem_19_1 {

    private static class Coordinate {
        public int x;
        public int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || this.getClass() != o.getClass()) {
                return false;
            }

            Coordinate that = (Coordinate) o;
            if (x != that.x || y != that.y) {
                return false;
            }
            return true;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

    }

    public static enum Color {
        WHITE, BLACK
    }

    public static List<Coordinate> searchMaze(List<List<Color>> maze, Coordinate s, Coordinate e) {
        List<Coordinate> path = new ArrayList<>();
        maze.get(s.x).set(s.y, Color.BLACK);
        path.add(s);

        if (!(searchMazeHelper(maze, s, e, path))) {
            path.remove(path.size() - 1);
        }

        return path;
    }

    public static boolean searchMazeHelper(List<List<Color>> maze, Coordinate curr, Coordinate dest,
            List<Coordinate> path) {
        if (curr.equals(dest)) {
            return true;
        }

        final int[][] SHIFT = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        for (int[] s : SHIFT) {
            Coordinate next = new Coordinate(curr.x + s[0], curr.y + s[1]);
            if (isFeasible(maze, next)) {
                maze.get(next.x).set(next.y, Color.BLACK);
                path.add(next);
                if (searchMazeHelper(maze, next, dest, path)){
                    return true;
                }    
                path.remove(path.size() - 1);
   
            }
            
        }

        return false;
    }

    public static boolean isFeasible(List<List<Color>> maze, Coordinate next) {
        return next.x >= 0 && next.x < maze.size() && next.y >= 0 && next.y < maze.get(next.x).size()
                && maze.get(next.x).get(next.y) == Color.WHITE;
    }

    public static void printPath(List<Coordinate> paths){
        for(Coordinate o : paths){
            System.out.print("( " + o.x + ", " + o.y + " ) ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<List<Color>> maze = new ArrayList<>();
        maze.add(new ArrayList<Color>(Arrays.asList(Color.BLACK, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE,
                Color.WHITE, Color.BLACK, Color.BLACK, Color.WHITE, Color.WHITE)));
        
        maze.add(new ArrayList<Color>(Arrays.asList(Color.WHITE, Color.WHITE, Color.BLACK, Color.WHITE, Color.WHITE,
                Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE)));
        
        maze.add(new ArrayList<Color>(Arrays.asList(Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, Color.WHITE,
                Color.BLACK, Color.BLACK, Color.WHITE, Color.BLACK, Color.BLACK)));
       
        maze.add(new ArrayList<Color>(Arrays.asList(Color.WHITE, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK,
                Color.BLACK, Color.WHITE, Color.WHITE, Color.BLACK, Color.WHITE)));
        
        maze.add(new ArrayList<Color>(Arrays.asList(Color.WHITE, Color.BLACK, Color.BLACK, Color.WHITE, Color.WHITE,
                Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE)));
        
        maze.add(new ArrayList<Color>(Arrays.asList(Color.WHITE, Color.BLACK, Color.BLACK, Color.WHITE, Color.WHITE,
                Color.BLACK, Color.WHITE, Color.BLACK, Color.BLACK, Color.WHITE)));
        
        maze.add(new ArrayList<Color>(Arrays.asList(Color.BLACK, Color.WHITE, Color.WHITE, Color.WHITE, Color.BLACK,
                Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE)));
        
        maze.add(new ArrayList<Color>(Arrays.asList(Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, Color.BLACK,
                Color.WHITE, Color.BLACK, Color.WHITE, Color.WHITE, Color.WHITE)));
        
        maze.add(new ArrayList<Color>(Arrays.asList(Color.BLACK, Color.WHITE, Color.BLACK, Color.BLACK, Color.WHITE,
                Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK, Color.BLACK)));
        
        maze.add(new ArrayList<Color>(Arrays.asList(Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE,
                Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK, Color.WHITE)));

        List<Coordinate> path = searchMaze(maze, new Coordinate(9, 0), new Coordinate(0, 9));

        printPath(path);
    }
}