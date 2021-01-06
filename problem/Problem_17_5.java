package problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
/*
Problem Description:
Search in 2D array
 */

public class Problem_17_5 {
    private static class Attempt {
        int x, y, offset;

        public Attempt(int x, int y, int offset) {
            this.x = x;
            this.y = y;
            this.offset = offset;
        }
    }

    public static boolean isPatternContainedInGrid(List<List<Integer>> grid, List<Integer> pattern) {
        Set<Attempt> previousAttempts = new HashSet<>();
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).size(); j++) {
                if (isPatternContainedInGridHelper(grid, pattern, 0, i, j, previousAttempts)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isPatternContainedInGridHelper(List<List<Integer>> grid, List<Integer> pattern, int offset,
            int x, int y, Set<Attempt> previousAttempts) {
        if (offset == pattern.size()) {
            return true;
        }
        if (x < 0 || x >= grid.size() || y < 0 || y >= grid.get(x).size()
                || previousAttempts.contains(new Attempt(x, y, offset))) {
            return false;
        }

        if (grid.get(x).get(y).equals(pattern.get(offset))
                && (isPatternContainedInGridHelper(grid, pattern, offset + 1, x - 1, y, previousAttempts)
                        || isPatternContainedInGridHelper(grid, pattern, offset + 1, x + 1, y, previousAttempts)
                        || isPatternContainedInGridHelper(grid, pattern, offset + 1, x, y - 1, previousAttempts)
                        || isPatternContainedInGridHelper(grid, pattern, offset + 1, x, y + 1, previousAttempts))) {
            return true;
        }

        previousAttempts.add(new Attempt(x, y, offset));
        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(new ArrayList<>(Arrays.asList(1,2,3)));
        grid.add(new ArrayList<>(Arrays.asList(3,4,5)));
        grid.add(new ArrayList<>(Arrays.asList(5,6,7)));

        List<Integer> pattern = new ArrayList<>(Arrays.asList(1,3,4,6));

        System.out.println(isPatternContainedInGrid(grid, pattern));
        pattern = new ArrayList<>(Arrays.asList(1,2,3,4));
        System.out.println(isPatternContainedInGrid(grid, pattern));
    }
}