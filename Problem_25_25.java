import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/*
Problem Statement:
Line Segment from above
*/

public class Problem_25_25 {

    public static class LineSegment {
        public int left, right;
        public int color;
        public int height;

        public LineSegment(int left, int right, int color, int height) {
            this.left = left;
            this.right = right;
            this.color = color;
            this.height = height;
        }

    }

    public static class EndPoint implements Comparable<EndPoint> {
        private boolean isLeft;
        private LineSegment line;

        public EndPoint(boolean isLeft, LineSegment line) {
            this.isLeft = isLeft;
            this.line = line;
        }

        public int value() {
            return isLeft ? line.left : line.right;
        }

        @Override
        public int compareTo(EndPoint o) {
            return Integer.compare(value(), o.value());
        }
    }

    public static List<LineSegment> calculateViewFromAbove(List<LineSegment> A) {
        List<EndPoint> sortedEndpoints = new ArrayList<>();

        for (LineSegment a : A) {
            sortedEndpoints.add(new EndPoint(true, a));
            sortedEndpoints.add(new EndPoint(false, a));
        }

        Collections.sort(sortedEndpoints);

        List<LineSegment> result = new ArrayList<>();
        int prevXAxis = sortedEndpoints.get(0).value();
        LineSegment prev = null;

        TreeMap<Integer, LineSegment> activeLineSegments = new TreeMap<>();
        for (EndPoint endpoint : sortedEndpoints) {

            if (!activeLineSegments.isEmpty() && prevXAxis != endpoint.value()) {
                if (prev == null) {
                    prev = new LineSegment(prevXAxis, endpoint.value(), activeLineSegments.lastEntry().getValue().color,
                            activeLineSegments.lastEntry().getValue().height);
                } else {
                    if (prev.height == activeLineSegments.lastEntry().getValue().height
                            && prev.color == activeLineSegments.lastEntry().getValue().color
                            && prevXAxis == prev.right) {
                        prev.right = endpoint.value();
                    } else {
                        result.add(prev);
                        prev = new LineSegment(prevXAxis, endpoint.value(),
                                activeLineSegments.lastEntry().getValue().color,
                                activeLineSegments.lastEntry().getValue().height);
                    }
                }
            }

            prevXAxis = endpoint.value();
            if (endpoint.isLeft) {
                activeLineSegments.put(endpoint.line.height, endpoint.line);
            } else {
                activeLineSegments.remove(endpoint.line.height);
            }
        }

        if (prev != null) {
            result.add(prev);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}