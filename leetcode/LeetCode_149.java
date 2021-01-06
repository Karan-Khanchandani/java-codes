package leetcode;

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {

	private static class Line {
		private static class Rational {
			public Integer numerator;
			public Integer denominator;
			public Rational(Integer numerator, Integer denominator) {
				this.numerator = numerator;
				this.denominator = denominator;
			}
            
            @Override
		public boolean equals(Object obj) {
			if (obj == null || !(obj instanceof Rational)) {
				return false;
			}
			if (this == obj) {
				return true;
			}
			Rational that = (Rational) obj;
			return numerator.equals(that.numerator) && denominator.equals(that.denominator);
        }
		}
        
        public static int calc_gcd(int a, int b){
            if(b == 0){
                return a;
            }
            
            return calc_gcd(b, a%b);
        }
		public static Rational getCanonicalFractional(int a, int b) {
			int gcd = calc_gcd(a, b);
			a /= gcd;
			b /= gcd;
			return b < 0 ? new Rational( - a, -b) : new Rational(a, b);
		}
		// Slope is a rational number. Note that if the line is parallel to y-axis
		// that we store 1/(9.
		private Rational slope;
		// Intercept is a rational number for the y-intercept unless
		// the line is parallel to y-axis in which case it is the x-intercept
		private Rational intercept;
		Line(Point a, Point b) {

			if (a.x != b.x) {
				slope = getCanonicalFractional(b.y - a.y, b.x - a.x);
			} else {
				slope = new Rational(1, 0);
			}
			if (a.x != b.x) {
				intercept = getCanonicalFractional(b.x * a.y - a.x * b.y, b.x - a.x);
			} else {
				intercept = new Rational(a.x, 1);
			}
		}
        
        @Override
		public boolean equals(Object obj) {
			if (obj == null || !(obj instanceof Line)) {
				return false;
			}
			if (this == obj) {
				return true;
			}
			Line that = (Line) obj;
			return slope.equals(that.slope) && intercept.equals(that.intercept);
        }
            @Override
			public int hashCode() {
				return Objects.hash(slope.numerator, slope.denominator, intercept.numerator, intercept.denominator);

			}
		}
    
		public int maxPoints(Point[] points) {

			if (points == null || points.length == 0) {
				return 0;
			}

			if (points.length == 1) {
				return 1;
			}

			Map < Line,
			Set < Point >> table = new HashMap < >();

			for (int i = 0; i < points.length; i++) {
				for (int j = 0; j < points.length; j++) {
					Line l = new Line(points[i], points[j]);

					Set < Point > s1 = table.get(l);

					if (s1 == null) {
						s1 = new HashSet < >();
						table.put(l, s1);
					}
					s1.add(points[i]);

					Set < Point > s2 = table.get(l);

					if (s2 == null) {
						s2 = new HashSet < >();
						table.put(l, s2);
					}
					s2.add(points[j]);
				}
			}

			System.out.println(table.entrySet().size());

			return Collections.max(table.entrySet(), new Comparator < Map.Entry < Line, Set < Point >>> () {@Override

				public int compare(Map.Entry < Line, Set < Point >> e1, Map.Entry < Line, Set < Point >> e2) {
					if (e1 != null && e2 != null) {
						return Integer.compare(e1.getValue().size(), e2.getValue().size());
					}

					return (e1 != null) ? 1 : -1;
				}
			}).getValue().size();
		}
	}
