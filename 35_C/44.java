import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.Queue;

public class A {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner("input.txt");
        PrintWriter out = new PrintWriter("output.txt");
        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
        int[][] dist = new int[n][m];
        for(int[] a : dist) Arrays.fill(a, -1);
        Queue<Point> q = new LinkedList<>();
        for(int i = 0; i < k; i++)
        {
            int x = sc.nextInt() - 1, y = sc.nextInt() - 1;
            dist[x][y] = 0;
            q.add(new Point(x, y));
        }
        int ansX = -1, ansY = -1;
        while(!q.isEmpty())
        {
            Point cur = q.remove();
            ansX = cur.x; ansY = cur.y;
            for(int i = 0; i < 4; i++)
            {
                int x = cur.x + dx[i], y = cur.y + dy[i];
                if(x != -1 && y != -1 && x != n && y != m && dist[x][y] == -1)
                {
                    q.add(new Point(x, y));
                    dist[x][y] = dist[cur.x][cur.y] + 1;
                }
            }
        }
        out.println((ansX + 1) + " " + (ansY + 1));
        out.flush();
        out.close();
    }
    static class Scanner
    {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream system) {br = new BufferedReader(new InputStreamReader(system));}
        public Scanner(String file) throws Exception {br = new BufferedReader(new FileReader(file));}
        public String next() throws IOException
        {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        public String nextLine()throws IOException{return br.readLine();}
        public int nextInt() throws IOException {return Integer.parseInt(next());}
        public double nextDouble() throws IOException {return Double.parseDouble(next());}
        public char nextChar()throws IOException{return next().charAt(0);}
        public Long nextLong()throws IOException{return Long.parseLong(next());}
        public boolean ready() throws IOException{return br.ready();}
        public void waitForInput() throws InterruptedException {Thread.sleep(4000);}
    }
}
