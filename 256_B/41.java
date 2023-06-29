import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solver {

    StringTokenizer st;
    BufferedReader in;
    PrintWriter out;

    public static void main(String[] args) throws NumberFormatException,
            IOException {
        Solver solver = new Solver();
        solver.open();
        solver.solve();
        solver.close();
    }

    public void open() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
    }

    public String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = in.readLine();
            if (line == null)
                return null;
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

    public int nextInt() throws NumberFormatException, IOException {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() throws NumberFormatException, IOException {
        return Long.parseLong(nextToken());
    }

    public double nextDouble() throws NumberFormatException, IOException {
        return Double.parseDouble(nextToken());
    }

    int n;

    class Otr {
        int x1, y1, x2, y2;
        int dx, dy;

        public Otr(int x, int y, int dx, int dy) {
            super();
            this.x1 = x;
            this.y1 = y;
            this.x2 = x;
            this.y2 = y;
            this.dx = dx;
            this.dy = dy;
        }

        int getAns() {
            if (x1 == x2 && y1 == y2) {
                int nx1 = x1 + dx;
                int ny2 = y2 + dy;

                if ((nx1 <= 0 || nx1 > n) && (ny2 <= 0 || ny2 > n)) {
                    return 0;
                }
            }

            x1 += dx;
            if (x1 <= 0) {
                x1 = 1;
                y1 += dy;
            }
            if (x1 > n) {
                x1 = n;
                y1 += dy;
            }

            y2 += dy;
            if (y2 <= 0) {
                y2 = 1;
                x2 += dx;
            }
            if (y2 > n) {
                y2 = n;
                x2 += dx;
            }

            return Math.abs(x1 - x2) + 1;
        }

        @Override
        public String toString() {
            return "(" + x1 + "," + y1 + ")->(" + x2 + "," + y2 + ")";
        }
    }

    int[] dxs = { -1, -1, 1, 1 };
    int[] dys = { -1, 1, -1, 1 };

    public void solve() throws NumberFormatException, IOException {
        n = nextInt();
        int x = nextInt();
        int y = nextInt();
        long c = nextLong();
        long now = 1;

        Otr[] otr = new Otr[4];
        for (int i = 0; i < 4; i++) {
            otr[i] = new Otr(x, y, dxs[i], dys[i]);
        }

        int result = 0;

        while (now < c) {
            for (int i = 0; i < 4; i++) {
                now += otr[i].getAns();
            }

            for (int i = 0; i < 3; i++) {
                for (int j = i + 1; j < 4; j++) {
                    Otr o1 = otr[i];
                    Otr o2 = otr[j];

                    if (o1.x1!=o1.x2 || o1.y1!=o1.y2){
                        if (o2.x1!=o2.x2 || o2.y1!=o2.y2){
                            if (o1.x1 == o2.x1 && o1.y1 == o2.y1) {
                                now--;
                            }
                            if (o1.x1 == o2.x2 && o1.y1 == o2.y2) {
                                now--;
                            }
                            if (o1.x2 == o2.x1 && o1.y2 == o2.y1) {
                                now--;
                            }
                            if (o1.x2 == o2.x2 && o1.y2 == o2.y2) {
                                now--;
                            }
                        }else{
                            if (o1.x1 == o2.x1 && o1.y1 == o2.y1) {
                                now--;
                            }
                            if (o1.x2 == o2.x1 && o1.y2 == o2.y1) {
                                now--;
                            }
                        }
                    }else{
                        if (o2.x1!=o2.x2 || o2.y1!=o2.y2){
                            if (o1.x2 == o2.x1 && o1.y2 == o2.y1) {
                                now--;
                            }
                            if (o1.x2 == o2.x2 && o1.y2 == o2.y2) {
                                now--;
                            }
                        }else{
                            if (o1.x1 == o2.x1 && o1.y1 == o2.y1) {
                                now--;
                            }
                        }
                    }
                    
                    
                }
            }

            result++;
        }

        out.println(result);
    }

    public void close() {
        out.flush();
        out.close();
    }
}