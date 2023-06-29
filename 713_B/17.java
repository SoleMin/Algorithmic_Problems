import javax.crypto.AEADBadTagException;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author AlexFetisov
 */
public class TaskB_AF {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB_cf371 solver = new TaskB_cf371();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB_cf371 {
        List<Rectangle> rects;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();

            int xLeft = 1, xRight = n;
            int xSeparate = -1;
            while (xLeft <= xRight) {
                int e = (xLeft + xRight) / 2;
                int t = makeRequest(in, out, 1, 1, e, n);
                if (t == 1) {
                    xSeparate = e;
                    xRight = e - 1;
                } else if (t == 0) {
                    xLeft = e + 1;
                } else {
                    xRight = e - 1;
                }
            }
            rects = new ArrayList<Rectangle>();
            if (xSeparate != -1 && makeRequest(in, out, xSeparate + 1, 1, n, n) == 1) {
                detectRectangle(in, out, 1, 1, xSeparate, n);
                detectRectangle(in, out, xSeparate + 1, 1, n, n);

                out.print("! ");
                for (Rectangle r : rects) {
                    out.print(r.toString() + " ");
                }
                out.println();
                out.flush();
                return;
            }

            int yLeft = 1, yRight = n;
            int ySeparate = -1;
            while (yLeft <= yRight) {
                int e = (yLeft + yRight) / 2;
                int t = makeRequest(in, out, 1, 1, n, e);
                if (t == 1) {
                    ySeparate = e;
                    yRight = e - 1;
                } else if (t == 0) {
                    yLeft = e + 1;
                } else {
                    yRight = e - 1;
                }
            }

            if (ySeparate != -1) {
                detectRectangle(in, out, 1, 1, n, ySeparate);
                detectRectangle(in, out, 1, ySeparate + 1, n, n);

                out.print("! ");
                for (Rectangle r : rects) {
                    out.print(r.toString() + " ");
                }
                out.println();
                out.flush();
                return;
            }
            throw new AssertionError("!");
        }

        private void detectRectangle(InputReader in, PrintWriter out, int xMin, int yMin, int xMax, int yMax) {
            int xLeft = -1, xRight = -1, yLeft = -1, yRight = -1;

            int left = xMin, right = xMax;
            while (left <= right) {
                int e = (left + right) / 2;
                if (makeRequest(in, out, xMin, yMin, e, yMax) == 1) {
                    xRight = e;
                    right = e - 1;
                } else {
                    left = e + 1;
                }
            }

            left = xMin;
            right = xRight;
            while (left <= right) {
                int e = (left + right) / 2;
                if (makeRequest(in, out, e, yMin, xRight, yMax) == 1) {
                    xLeft = e;
                    left = e + 1;
                } else {
                    right = e - 1;
                }
            }

            left = yMin;
            right = yMax;
            while (left <= right) {
                int e = (left + right) / 2;
                if (makeRequest(in, out, xLeft, yMin, xRight, e) == 1) {
                    yRight = e;
                    right = e - 1;
                } else {
                    left = e + 1;
                }
            }

            left = yMin;
            right = yRight;
            while (left <= right) {
                int e = (left + right) / 2;
                if (makeRequest(in, out, xLeft, e, xRight, yRight) == 1) {
                    yLeft = e;
                    left = e + 1;
                } else {
                    right = e - 1;
                }
            }
            rects.add(new Rectangle(xLeft, yLeft, xRight, yRight));
        }

        private int makeRequest(InputReader in, PrintWriter out, int x1, int y1, int x2, int y2) {
            out.print("? " + x1 + " " + y1 + " " + x2 + " " + y2);
            out.println();
            out.flush();
            return in.nextInt();
        }

        class Rectangle {
            int x1;
            int x2;
            int y1;
            int y2;

            public Rectangle(int x1, int y1, int x2, int y2) {
                this.x1 = x1;
                this.x2 = x2;
                this.y1 = y1;
                this.y2 = y2;
            }


            public String toString() {
                StringBuilder b = new StringBuilder("");
                b.append(x1).append(' ');
                b.append(y1).append(' ');
                b.append(x2).append(' ');
                b.append(y2);
                return b.toString();
            }

        }

    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer stt;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                return null;
            }
        }

        public String nextString() {
            while (stt == null || !stt.hasMoreTokens()) {
                stt = new StringTokenizer(nextLine());
            }
            return stt.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextString());
        }

    }
}
