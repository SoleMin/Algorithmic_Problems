import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class cf8c {
  static int n;
  static int[] bb;
  static int[] memo;
  static int[][] cost;
  static FastIO in = new FastIO(), out = in;
  public static void main(String[] args) {
    vec2 cen = new vec2(in.nextInt(),in.nextInt());
    n = in.nextInt();
    cost = new int[n][n];
    vec2[] v = new vec2[n];
    for(int i=0; i<n; i++)
      v[i] = new vec2(in.nextInt(),in.nextInt());
    for(int i=0; i<n; i++)
      for(int j=0; j<n; j++)
        cost[i][j] = v[i].dist(cen) + v[i].dist(v[j]) + v[j].dist(cen);
    memo = new int[1<<n];
    bb = new int[1<<n];
    Arrays.fill(memo,-1);
    out.println(go(0));
    build(0);
    out.close();
  }
  static void build(int mask) {
    if(mask == (1<<n)-1) {
      out.println(0);
      return;
    }
    int first = 0;
    while((mask & (1<<first)) != 0) first++;
    int second = bb[mask];
    out.print("0 " + (first+1) + " ");
    if(second != first)
      out.print((second+1)+" ");
    build(mask|(1<<first)|(1<<second));
  }
  static int go(int mask) {
    if(mask == (1<<n)-1) return 0;
    if(memo[mask] != -1) return memo[mask];
    int first = 0;
    int ans = Integer.MAX_VALUE;
    while((mask & (1<<first)) != 0) first++;
    for(int second = first; second < n; second++) {
      if((mask & (1<<second)) != 0) continue;
      int tans = cost[first][second] + go(mask|(1<<first)|(1<<second));
      if(tans < ans) {
        ans = tans;
        bb[mask] = second;
      }
    }
    return memo[mask] = ans;
  }
  static class vec2 {
    int x, y;
    vec2(int a, int b) {
      x = a; y = b;
    }
    vec2 sub(vec2 v) {
      return new vec2(x-v.x,y-v.y);
    }
    int dist(vec2 v) {
      return sub(v).mag2();
    }
    int mag2() {
      return x*x+y*y;
    }
  }
  static class FastIO extends PrintWriter {
    BufferedReader br;
    StringTokenizer st;
    
    public FastIO() {
      this(System.in,System.out);
    }
    public FastIO(InputStream in, OutputStream out) {
      super(new BufferedWriter(new OutputStreamWriter(out)));
      br = new BufferedReader(new InputStreamReader(in));
      scanLine();
    }
    public void scanLine() {
      try {
        st = new StringTokenizer(br.readLine().trim());
      } catch(Exception e) {
        throw new RuntimeException(e.getMessage());
      }
    }
    public int numTokens() {
      if(!st.hasMoreTokens()) {
        scanLine();
        return numTokens();
      }
      return st.countTokens();
    }
    public String next() {
      if(!st.hasMoreTokens()) {
        scanLine();
        return next();
      }
      return st.nextToken();
    }
    public double nextDouble() {
      return Double.parseDouble(next());
    }
    public long nextLong() {
      return Long.parseLong(next());
    }
    public int nextInt() {
      return Integer.parseInt(next());
    }
  }
}
