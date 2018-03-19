import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LeetCode_56 {

    public static class Interval {
        int start;
        int end;

        public Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                if (i1.start != i2.start) {
                    return (i1.start - i2.start);
                }
                return (i2.end - i1.end);
            }
        });

        for (int k = 0; k < intervals.size(); k++) {
            while (k + 1 < intervals.size() && intervals.get(k + 1).start <= intervals.get(k).end) {
                //merge
                intervals.get(k).end = Math.max(intervals.get(k).end, intervals.get(k + 1).end);
                intervals.remove(k + 1);
            }

        }

        return intervals;
    }

    public static void printList(List<Interval> list) {
        
        for (Interval i : list) {
            System.out.print("[ " + i.start + ", " + i.end + " ] ");
        }
        
        System.out.println();
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        // 1,3],[2,6],[8,10],[15,18]
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));

        printList(intervals);

        intervals = merge(intervals);

        printList(intervals);

    }
}
