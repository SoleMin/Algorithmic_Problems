import java.io.*;
import java.util.*;

public class Main {
    public static point[] points;

    static class point implements Comparable<point> {
        int x, y;

        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(point o) {
            if (this.x  > o.x ) {
                return 1;
            } else if (this.x  == o.x ) {
                return 0;
            } else {
                return -1;
            }
        }

        @Override
        public String toString() {
            return x + " " + y;
        }

        @Override
        public boolean equals(Object obj) {
            point point = (point) obj;
            return Objects.equals(x, point.x) && Objects.equals(y, point.y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) throws Exception {
        points = new point[3];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            points[i] = new point(a, b);
        }

        Arrays.sort(points);

        int lMax = Math.max(Math.max(points[0].y, points[1].y), points[2].y);
        int lMin = Math.min(Math.min(points[0].y, points[1].y), points[2].y);
        int rMax = Math.max(Math.max(points[0].x, points[1].x), points[2].x);
        int rMin = Math.min(Math.min(points[0].x, points[1].x), points[2].x);

        Set<point> sets = new HashSet<>();

        for (int i = lMin; i <= lMax; i++) {
            sets.add(new point(points[1].x, i));
        }
        for (int i = rMin; i <= points[1].x; i++) {
            sets.add(new point(i, points[0].y));
        }
        for (int i = points[1].x; i <= rMax; i++) {
            sets.add(new point(i, points[2].y));
        }
        System.out.println(sets.size());
        for (point i : sets) {
            System.out.println(i);
        }
    }
}

	  			  	 		 	 			  	 	   					