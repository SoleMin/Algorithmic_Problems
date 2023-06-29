import java.io.*;
import java.util.*;

public class Template implements Runnable {

    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    void init() throws FileNotFoundException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
    }

    String readString() throws IOException {
        while (!tok.hasMoreTokens()) {
            try {
                tok = new StringTokenizer(in.readLine(), " :");
            } catch (Exception e) {
                return null;
            }
        }
        return tok.nextToken();
    }

    int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    int[] readIntArray(int size) throws IOException {
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = readInt();
        }
        return res;
    }

    long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    double readDouble() throws IOException {
        return Double.parseDouble(readString());
    }

    <T> List<T>[] createGraphList(int size) {
        List<T>[] list = new List[size];
        for (int i = 0; i < size; i++) {
            list[i] = new ArrayList<>();
        }
        return list;
    }

    public static void main(String[] args) {
        new Thread(null, new Template(), "", 1l * 200 * 1024 * 1024).start();
    }

    long timeBegin, timeEnd;

    void time() {
        timeEnd = System.currentTimeMillis();
        System.err.println("Time = " + (timeEnd - timeBegin));
    }

    long memoryTotal, memoryFree;

    void memory() {
        memoryFree = Runtime.getRuntime().freeMemory();
        System.err.println("Memory = " + ((memoryTotal - memoryFree) >> 10)
                + " KB");
    }

    public void run() {
        try {
            timeBegin = System.currentTimeMillis();
            memoryTotal = Runtime.getRuntime().freeMemory();
            init();
            solve();
            out.close();
            if (System.getProperty("ONLINE_JUDGE") == null) {
                time();
                memory();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    int fx = -1;
    int sx = -1;
    int fy = -1;
    int sy = -1;

    int query(int x1, int y1, int x2, int y2) throws IOException {
        out.println("? " + x1 + " " + y1 + " " + x2 + " " + y2);
        out.flush();
        int res = readInt();
        if (fx >= x1 && sx <= x2 && fy >= y1 && sy <= y2) res--;
        return res;
    }

    int[] bs(int n) throws IOException {
        int l = 1;
        int r = n;

        int lx = 0, rx = 0, ly = 0, ry = 0;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (query(1, 1, mid, n) > 0) {
                rx = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        l = 1;
        r = rx;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (query(mid, 1, rx, n) > 0) {
                lx = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        l = 1;
        r = n;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (query(lx, mid, rx, n) > 0) {
                ly = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        l = ly;
        r = n;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (query(lx, ly, rx, mid) > 0) {
                ry = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        fx = lx;
        sx = rx;
        fy = ly;
        sy = ry;
        return new int[] {lx, ly, rx, ry};
    }

    void solve() throws IOException {
        int n = readInt();
        int[] a = bs(n);
        int[] b = bs(n);

        out.print("! ");
        for (int i : a) out.print(i + " ");
        for (int i : b) out.print(i + " ");
    }


}