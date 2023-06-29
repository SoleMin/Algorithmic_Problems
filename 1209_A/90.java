import java.util.*;

public class task1 {
    static void print(Object... a) {
        for (Object aa : a) {
            System.out.println(aa.toString());
        }
    }

    static Map<Character, Integer> stringToCharsMap(String str) {
        Map<Character, Integer> charcount = new HashMap<Character, Integer>();
        for (Character c : str.toCharArray()) {
            if (charcount.containsKey(c)) {
                charcount.put(c, charcount.get(c) + 1);
            } else {
                charcount.put(c, 1);
            }
        }
        return charcount;
    }

    static Set<Character> stringToCharsSet(String str) {
        Set<Character> chars = new HashSet<>();
        for (Character c : str.toCharArray()) {
            chars.add(c);
        }
        return chars;
    }

    static int[] readArrayOfInt() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int array[] = new int[a];
        for (int i = 0; i < a; i++) {
            array[i] = sc.nextInt();
        }
        return array;
    }

    static class Point {
        double x;
        double y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        double distance(Point p) {
            return Math.sqrt((this.x - p.x) * (this.x - p.x) + (this.y - p.y) * (this.y - p.y));
        }

        double distance(Line l) {
            return Math.abs(l.a * this.x + l.b * this.y + l.c) / Math.sqrt(l.a * l.a + l.b * l.b);
        }
    }

    static class Line {
        double a;
        double b;
        double c;
        double EPS = 1e-6;

        Line(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        Line(Point f, Point s) {
            this.a = f.y - s.y;
            this.b = s.x - f.x;
            this.c = -this.a * f.x - this.b * f.y;
        }

        double distance(Point p) {
            return Math.abs(this.a * p.x + this.b * p.y + this.c) / Math.sqrt(this.a * this.a + this.b * this.b);
        }

        boolean isPointOnLine(Point p) {
            return p.x * this.a + p.y * this.b + this.c < EPS;
        }

        Point linesIntersection(Line a) {
            double x = -(this.c * a.b - a.c * this.b) / (this.a * a.b - a.a * this.b);
            double y = -(this.a * a.c - a.a * this.c) / (this.a * a.b - a.a * this.b);
            return new Point(x, y);
        }
    }

    static HashMap<Integer, Integer> getDels(int a) {
        HashMap<Integer, Integer> h = new HashMap<>();
        int i = 2;
        while (a != 1) {
            if (a % i == 0) {
                if (h.containsKey(i)) {
                    h.put(i, h.get(i) + 1);
                } else {
                    h.put(i, 1);
                }
                a = a / i;
            } else {
                i++;
            }
        }
        return h;
    }

    static class Rect {
        Point fcorner;
        Point scorner;

        Rect(Point f, Point s) {
            fcorner = f;
            scorner = s;
        }

        double volume() {
            return Math.abs((fcorner.x - scorner.x) * (fcorner.y - scorner.y));
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        int c[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int count = 1;
        c[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    c[i] = c[j];
                    break;
                }
            }
            if (c[i] == 0) {
                c[i] = count + 1;
                count++;
            }
        }
        System.out.println(count);
    }
}
