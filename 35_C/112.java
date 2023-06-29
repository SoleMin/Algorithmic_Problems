import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Problem implements Runnable {

    private static final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;

    private BufferedReader in;
    private PrintWriter out;
    private StringTokenizer tok = new StringTokenizer("");

    private void init() throws FileNotFoundException {
        Locale.setDefault(Locale.US);
        String fileName = "";
     /*   if (ONLINE_JUDGE && fileName.isEmpty()) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        } else {
            if (fileName.isEmpty()) {*/
                in = new BufferedReader(new FileReader("input.txt"));
                out = new PrintWriter("output.txt");
          /*  } else {
                in = new BufferedReader(new FileReader(fileName + ".in"));
                out = new PrintWriter(fileName + ".out");
           /* }
        }*/
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
        new Problem().run();
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
            solve();
            out.close();
            time();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    int[][] dist;
    int n, m;

    private void solve() throws IOException {
        n = readInt();
        m = readInt();
        int k=readInt();
        dist = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                dist[i][j] = -1;
        for (int i = 0; i < k; i++) {
            dist[readInt()-1][readInt()-1]=0;
        }
        for (int i=0;i<n;i++)
            for (int j=0;j<m;j++)
                if (dist[i][j]==0)
                    bfs(i, j);
        int max=0,X=0,Y=0;
        for (int i=0;i<n;i++)
            for (int j=0;j<m;j++)
                if (dist[i][j]>=max){
                    max=dist[i][j];
                    X=i+1; Y=j+1;
                }
        out.println(X+" "+Y);
    }

    public void bfs(int x, int y) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        dist[x][y] = 0;
        ArrayDeque<P> q = new ArrayDeque<>();
        q.add(new P(x, y));
        while (!q.isEmpty()) {
            P v = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = v.x + dx[i];
                int ny = v.y + dy[i];
                if (inside(nx, ny) && (dist[nx][ny] == -1 || (dist[nx][ny] > dist[v.x][v.y] + 1&&dist[nx][ny]!=0))) {
                    q.add(new P(nx, ny));
                    dist[nx][ny] = dist[v.x][v.y] + 1;
                }
            }
        }
    }

    public boolean inside(int x, int y) {
        if (x < n && y < m && x >= 0 && y >= 0) {
            return true;
        }
        return false;
    }
}


class P {
    int x, y;

    public P(int x, int y) {
        this.x = x;
        this.y = y;
    }
}