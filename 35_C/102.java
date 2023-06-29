import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class R035CRetry {
    public void debug(Object... objects) { System.err.println(Arrays.deepToString(objects)); }
    public static final int INF = 987654321;
    public static final long LINF = 987654321987654321L;
    public static final double EPS = 1e-9;
    
    Scanner scanner;
    PrintWriter out;
    boolean[][] bss;
    
    public R035CRetry() {
        try {
            this.scanner = new Scanner(new File("input.txt"));
            this.out = new PrintWriter("output.txt");
        } catch(FileNotFoundException ex) { ex.printStackTrace(); }
    }
    
    class Point implements Comparable<Point> {
        int x, y, count;
        Point(int x, int y) { this.x = x; this.y = y; }
        public int hashCode() { return x * 17 + y; }
        public boolean equals(Object o) {
            if(!(o instanceof Point)) return false;
            Point that = (Point)o;
            return this.x == that.x && this.y == that.y;
        }
        public int compareTo(Point that) { return this.count - that.count; }
        public String toString()  { return "(" + x + ", " + y + ":" + count + ")"; }
    }

    
    int[] dx = new int[] {  0, 0, -1, 1 };
    int[] dy= new int[] { -1, 1,  0, 0 };
    int n, m;
    
    Queue<Point> q;
    
    Point bfs() {
        int max = -INF;
        Point p = null;
        while(!q.isEmpty()) {
            Point cur = q.remove();
            if(max < cur.count) { max = cur.count; p = cur; } 
            for(int i=0; i<dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx < 0 || nx >= n) { continue; }
                if(ny < 0 || ny >= m) { continue; }
                Point np = new Point(nx, ny);
                if(bss[nx][ny] ) { continue; } 
                np.count = cur.count+1;
                bss[nx][ny] = true;
                q.add(np);
            }
        }
        return p;
    }
    
    private void solve() {
        this.n = scanner.nextInt();
        this.m = scanner.nextInt();
        this.bss = new boolean[n][m];
        int k = scanner.nextInt();
        q = new LinkedList<Point>();
        for(int i=0; i<k; i++) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            Point init = new Point(x, y);
            init.count = 1;
            q.add(init);
            bss[x][y] = true;
        }
        Point p = bfs();
        out.println((p.x+1) + " " + (p.y+1));
    }
    
    private void finish() { this.out.close(); }
    
    public static void main(String[] args) { 
        R035CRetry obj = new R035CRetry();
        obj.solve();
        obj.finish();
    }
}
