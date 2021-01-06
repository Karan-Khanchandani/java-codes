package problem;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/*
Find the line passing through max points
*/


public class Problem_25_19{

    public static class Rational{
        public Integer numerator;
        public Integer denominator;

        public Rational(Integer numerator, Integer denominator){
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    public static class Point{
        public Integer x;
        public Integer y;

        public Point(Integer x , Integer y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Line{
        public Rational slope;
        public Rational intercept;

        public static Rational getCanonicalForm(int a, int b){
            int gcd = BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).intValue();
            a /= gcd;
            b /= gcd;

            return b < 0 ? new Rational(-a, -b) : new Rational(a, b);
        }

        public Line(Point a, Point b){
            if(a.x != b.x){
                slope = getCanonicalForm(b.y - a.y, b.x - a.x);
            }else{
                slope = new Rational(0, 1);
            }

            if(a.x != b.x){
                intercept = new Rational(b.x*a.y - a.x*b.y, b.x - a.x);
            }else{
                intercept = new Rational(a.x, 1);
            }
        }

        @Override
        public  boolean equals(Object o){
            if(this == o){
                return true;
            }

            if(o == null || !(o instanceof Line)){
                return false;
            }

            Line that = (Line) o;
            return slope.equals(that.slope) && intercept.equals(that.intercept);
        }

        @Override
        public int hashCode(){
            return Objects.hash(slope.numerator, slope.denominator, intercept.numerator, intercept.denominator);
        }
    }

    public static Line linePassingThroughMaxPoints(List<Point> points){

        Map<Line, Set<Point>> table = new HashMap<>();
        for(int i = 0; i < points.size(); i++){
            for(int j = i+1; j < points.size(); j++){
                Line l = new Line(points.get(i), points.get(j));

                Set<Point> s1 = table.get(l);

                if(s1 == null){
                    s1 = new HashSet<>();
                    table.put(l, s1);
                }
                s1.add(points.get(i));

                Set<Point> s2 = table.get(l);

                if(s2 == null){
                    s2 = new HashSet<>();
                    table.put(l, s2);
                }
                s2.add(points.get(j));

            }
        }

        return Collections.max(table.entrySet(),
        new Comparator<Map.Entry<Line, Set<Point>>>() {
            @Override
            public int compare(Map.Entry<Line, Set<Point>> e1, Map.Entry<Line, Set<Point>> e2){
                if(e1 != null && e2 != null){
                    return Integer.compare(e1.getValue().size(), e2.getValue().size());
                }

                return (e1 != null) ? 1 : -1;
            }
        }
        
        ).getKey();
    }

    public static void printLine(Line l){
        System.out.print("y = ( " + l.slope.numerator + "/" + l.slope.denominator + " ) * x + ");
        System.out.print("( " +  l.intercept.numerator + "/" + l.intercept.denominator + " )");
        System.out.println();
    }

    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(-1, 1));
        points.add(new Point(0,0));
        points.add(new Point(1, 1));
        points.add(new Point(2, 2));
        points.add(new Point(3, 3));
        points.add(new Point(3, 4));

        Line l = linePassingThroughMaxPoints(points);

        printLine(l);
    }
}