import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution implements Runnable {
  BufferedReader in;
  PrintWriter out;
  StringTokenizer tok = new StringTokenizer("");

  @Override
  public void run() {
    try {
      init();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    long time = System.currentTimeMillis();
    try {
      solve();
    } catch (Exception e) {
      e.printStackTrace();
    }
    out.close();
    //System.err.println(System.currentTimeMillis() - time);
  }

  private void init() throws FileNotFoundException {
    String file = "123";
    if (!file.equals("")) {
      in = new BufferedReader(new FileReader("input.txt"));
      out = new PrintWriter("output.txt");
    } else {
      in = new BufferedReader(new InputStreamReader(System.in));
      out = new PrintWriter(System.out);
    }
  }

  public static void main(String[] args) {
    new Thread(new Solution()).start();
  }

  private String readString() {
    while (!tok.hasMoreTokens()) {
      try {
        tok = new StringTokenizer(in.readLine());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return tok.nextToken();
  }

  private int readInt() {
    return Integer.parseInt(readString());
  }

  int[] counts = new int[1000];

  private long readLong() {
    return Long.parseLong(readString());
  }

  private void solve() {
    int n = readInt()+2;
    int m = readInt()+2;
    boolean[][] graph = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      graph[i][m-1] = true;
      graph[i][0] = true;
    }
    for (int i = 0; i < m; i++) {
      graph[n-1][i] = true;
      graph[0][i] = true;
    }
    int k = readInt();
    int inFire = 0;
    Queue<Point> q = new ArrayDeque<>();
    for (int i = 0; i < k; i++) {
      int x = readInt();
      int y = readInt();
      Point p = new Point(x, y);
      graph[x][y] = true;
      q.add(p);
    }
    while (!q.isEmpty()) {
      Point current = q.poll();
      inFire++;
      if(!graph[current.x+1][current.y]) {
        graph[current.x+1][current.y] = true;
        q.add(new Point(current.x+1, current.y));
      }
      if(!graph[current.x-1][current.y]) {
        graph[current.x-1][current.y] = true;
        q.add(new Point(current.x-1, current.y));
      }
      if(!graph[current.x][current.y+1]) {
        graph[current.x][current.y+1] = true;
        q.add(new Point(current.x, current.y+1));
      }
      if(!graph[current.x][current.y-1]) {
        graph[current.x][current.y-1] = true;
        q.add(new Point(current.x, current.y-1));
      }
      if(q.isEmpty()) {
        out.print(current.x+" "+current.y);
        return;
      }
    }


  }

  class Point{
    int x, y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}