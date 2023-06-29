import java.io.*;
import java.util.Locale;
import java.util.StringTokenizer;

public class B implements Runnable {

    private static final boolean ONLINE_JUDGE = true;//System.getProperty("ONLINE_JUDGE") != null;

    private BufferedReader in;
    private PrintWriter out;
    private StringTokenizer tok = new StringTokenizer("");

    private void init() throws FileNotFoundException {
        Locale.setDefault(Locale.US);
        String fileName = "";
        if (ONLINE_JUDGE && fileName.isEmpty()) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        } else {
            if (fileName.isEmpty()) {
                in = new BufferedReader(new FileReader("input.txt"));
                out = new PrintWriter("output.txt");
            } else {
                in = new BufferedReader(new FileReader(fileName + ".in"));
                out = new PrintWriter(fileName + ".out");
            }
        }
    }

    String readString() {
        while (!tok.hasMoreTokens()) {
            try {
                tok = new StringTokenizer(in.readLine());
            } catch (Exception e) {
                return null;
            }
        }
        return tok.nextToken();
    }

    int readInt() {
        return Integer.parseInt(readString());
    }

    long readLong() {
        return Long.parseLong(readString());
    }

    double readDouble() {
        return Double.parseDouble(readString());
    }

    int[] readIntArray(int size) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = readInt();
        }
        return a;
    }

    public static void main(String[] args) {
        //new Thread(null, new _Solution(), "", 128 * (1L << 20)).start();
        new B().run();
    }

    long timeBegin, timeEnd;

    void time() {
        timeEnd = System.currentTimeMillis();
        System.err.println("Time = " + (timeEnd - timeBegin));
    }

    @Override
    public void run() {
        try {
            timeBegin = System.currentTimeMillis();
            init();
            int n = readInt();
            int[] rect1 = solve1(n);
            int[] rect2 = solve2(n, rect1);

            out.printf("! %s %s %s %s %s %s %s %s\n", rect1[0], rect1[1], rect1[2], rect1[3],
                    rect2[0], rect2[1], rect2[2], rect2[3]);
            out.flush();
            out.close();
            time();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    int ask(int x1, int y1, int x2, int y2) {
        out.println("? " + x1 + " " + y1 + " " + x2 + " " + y2);
        out.flush();
        return readInt();
    }

    int ask(int x1, int y1, int x2, int y2, int[] rect) {
        out.println("? " + x1 + " " + y1 + " " + x2 + " " + y2);
        out.flush();
        int res = readInt();
        if (rect[0] >= x1 && rect[2] <= x2 && rect[1] >= y1 && rect[3] <= y2) {
            res--;
        }
        return res;
    }

    int[] dropTopAndLeft1(int x2, int y2) {
        int x1 = x2, y1 = y2;
        int left = 1, right = x2;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int count = ask(mid, 1, x2, y2);
            if (count >= 1) {
                x1 = mid;
                left = mid + 1;
            }
            if (count == 0) {
                right = mid - 1;
            }
        }
        left = 1;
        right = y2;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int count = ask(x1, mid, x2, y2);
            if (count >= 1) {
                y1 = mid;
                left = mid + 1;
            }
            if (count == 0) {
                right = mid - 1;
            }
        }
        return new int[]{x1, y1, x2, y2};
    }

    private int[] solve1(int n) {

        int x = -1;
        int left = 1, right = n;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int count = ask(1, 1, mid, n);
            if (count >= 1) {
                x = mid;
                right = mid - 1;
            }
            if (count == 0) {
                left = mid + 1;
            }
        }

        left = 1;
        right = n;
        int y = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int count = ask(1, 1, x, mid);
            if (count >= 1) {
                y = mid;
                right = mid - 1;
            }
            if (count == 0) {
                left = mid + 1;
            }
        }

        return dropTopAndLeft1(x, y);
    }

    private int[] solve2(int n, int[] rect) {

        int x = -1;
        int left = 1, right = n;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int count = ask(mid, 1, n, n, rect);
            if (count >= 1) {
                x = mid;
                left = mid + 1;
            }
            if (count == 0) {
                right = mid - 1;
            }
        }

        left = 1;
        right = n;
        int y = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int count = ask(x, mid, n, n, rect);
            if (count >= 1) {
                y = mid;
                left = mid + 1;
            }
            if (count == 0) {
                right = mid - 1;
            }
        }

        return dropTopAndLeft2(x, y, n, rect);
    }

    int[] dropTopAndLeft2(int x1, int y1, int n, int[] rect) {
        int x2 = x1, y2 = y1;
        int left = x1, right = n;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int count = ask(x1, y1, mid, n, rect);
            if (count >= 1) {
                x2 = mid;
                right = mid - 1;
            }
            if (count == 0) {
                left = mid + 1;
            }
        }
        left = y1;
        right = n;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int count = ask(x1, y1, x2, mid, rect);
            if (count == 1) {
                y2 = mid;
                right = mid - 1;
            }
            if (count == 0) {
                left = mid + 1;
            }
        }
        return new int[]{x1, y1, x2, y2};
    }
}
