import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {


    public static void main(String[] args) {
        InputStream inputStream;
        try {
            inputStream = new FileInputStream("input.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        OutputStream outputStream;
        try {
            outputStream = new FileOutputStream("output.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {

        int[][] or;
        int n;
        int m;

        public void solve(int testNumber, InputReader in, PrintWriter out) {

            n = in.nextInt();
            m = in.nextInt();
            int k = in.nextInt();

            ArrayList<Point> arr1 = new ArrayList<>();
            ArrayList<Point> arr2 = new ArrayList<>();

            for (int i = 0; i < k; i++) {
                arr1.add(new Point(in.nextInt(), in.nextInt()));
            }

            or = new int[n + 1][m + 1];

            for (int i = 0; i < k; i++) {
                or[arr1.get(i).x][arr1.get(i).y] = -1;
            }

            Point lastValue = arr1.get(0);

            while (arr1.size() > 0 || arr2.size() > 0) {

                for (Point p : arr1) {
                    if (valid(new Point(p.x - 1, p.y))) {
                        arr2.add(new Point(p.x - 1, p.y));
                    }
                    if (valid(new Point(p.x + 1, p.y))) {
                        arr2.add(new Point(p.x + 1, p.y));
                    }
                    if (valid(new Point(p.x, p.y - 1))) {
                        arr2.add(new Point(p.x, p.y - 1));
                    }
                    if (valid(new Point(p.x, p.y + 1))) {
                        arr2.add(new Point(p.x, p.y + 1));
                    }
                }

                arr1.clear();

                if (arr2.size() > 0) {
                    lastValue = arr2.get(0);
                }

                for (Point p : arr2) {
                    if (valid(new Point(p.x - 1, p.y))) {
                        arr1.add(new Point(p.x - 1, p.y));
                    }
                    if (valid(new Point(p.x + 1, p.y))) {
                        arr1.add(new Point(p.x + 1, p.y));
                    }
                    if (valid(new Point(p.x, p.y - 1))) {
                        arr1.add(new Point(p.x, p.y - 1));
                    }
                    if (valid(new Point(p.x, p.y + 1))) {
                        arr1.add(new Point(p.x, p.y + 1));
                    }
                }

                arr2.clear();

                if (arr1.size() > 0) {
                    lastValue = arr1.get(0);
                }
            }

            out.println(lastValue.x + " " + lastValue.y);
        }

        boolean valid(Point p) {
            if ((p.x < 1 || p.x > n) ||
                    (p.y < 1 || p.y > m) ||
                    or[p.x][p.y] == -1) {
                return false;
            }

            or[p.x][p.y] = -1;

            return true;
        }

        class Point {

            int x;
            int y;

            public Point(int a, int b) {
                x = a;
                y = b;
            }

        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }

}








