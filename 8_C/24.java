import java.io.*;
import java.util.*;

public class A558 {
  static BufferedReader in = null;
  static PrintWriter out = null;
  static StringTokenizer st = new StringTokenizer("");

  public static void main(String[] args) {
    try {
      in = new BufferedReader(new InputStreamReader(System.in));
      out = new PrintWriter(System.out);
      solve();
      out.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static String readString() {
    while (!st.hasMoreTokens()) {
      try {
        st = new StringTokenizer(in.readLine(), " \n\r\t:");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return st.nextToken();
  }


  public static int readInt() {
    return Integer.parseInt(readString());
  }

  public static long readLong() {
    return Long.parseLong(readString());
  }

  private static int MAX_VALUE = Integer.MAX_VALUE - 10000000;
  private static int[] dp;
  private static int[] parents;
  private static int[] powers;
  private static int[] x;
  private static int[] y;
  private static int[][] dist;
  private static int[] distFrom0;

  private static void solve() throws IOException {
    int x0 = readInt();
    int y0 = readInt();
    int n = readInt();
    long time = System.currentTimeMillis();
    x = new int[n];
    y = new int[n];
    for (int i = 0; i < n; i++) {
      x[i] = readInt() - x0;
      y[i] = readInt() - y0;
    }
    dist = new int[n][n];
    distFrom0 = new int[n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        dist[i][j] = (x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]);
      }
    }
    for (int i = 0; i < n; i++) {
      distFrom0[i] = x[i] * x[i] + y[i] * y[i];
    }
    powers = new int[n + 1];
    powers[0] = 1;
    for (int i = 1; i < n + 1; i++) {
      powers[i] = powers[i - 1] * 2;
    }
    int maxMask = 1 << n;
    dp = new int[maxMask];
    parents = new int[maxMask];
    Arrays.fill(dp, MAX_VALUE);
    dp[0] = 0;
    for (int i = 0; i < maxMask; i++) {
      if (dp[i] != MAX_VALUE) {
        int curMask = i;
        int notUsed = 0;
        for (int j = 0; j < n; j++) {
          if ((curMask & powers[j]) == 0) {
            notUsed = j;
            break;
          }
        }
        int mask = curMask | powers[notUsed];
        for (int j = notUsed; j < n; j++) {
          if ((powers[j] & curMask) == 0 || j == notUsed) {
            int nextMask = mask | powers[j];
            int minDist = dp[curMask] + distFrom0[notUsed] + dist[notUsed][j] + distFrom0[j];
            if (dp[nextMask] > minDist) {
              dp[nextMask] = minDist;
              parents[nextMask] = curMask;
            }
          }
        }
      }
    }
   // System.err.println(((System.currentTimeMillis() - time)));
    // brute(n, 0)
    maxMask--;
    out.println(dp[maxMask]);
    while (maxMask != 0) {
      out.print("0 ");
      int[] diffBits = getBits(n, maxMask, parents[maxMask]);
      for (int i = 1; i <= diffBits[0]; i++) {
        out.print(diffBits[i] + 1 + " ");
      }
      maxMask = parents[maxMask];
    }
    out.print(0);
    //System.err.println((System.currentTimeMillis() - time));
  }

  private static boolean hasBit(int x, int index) {
    return (powers[index] & x) != 0;
  }

  private static int setBit(int x, int index) {
    return (x | powers[index]);
  }

  private static int getDist(int xFrom, int yFrom, int xTo, int yTo) {
    return (xTo - xFrom) * (xTo - xFrom) + (yTo - yFrom) * (yTo - yFrom);
  }

  private static int[] getBits(int n, int nextMask, int curMask) {
    int[] res = new int[3];
    for (int i = 0; i < n; i++) {
      if (hasBit(nextMask, i) ^ hasBit(curMask, i)) {
        res[++res[0]] = i;
      }
    }
    return res;
  }

  private static void brute(int n, int mask) {
    List<Integer> listNotTaken = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (!hasBit(mask, i)) {
        listNotTaken.add(i);
      }
    }
    for (int first : listNotTaken) {
      int temp = setBit(mask, first);
      for (int second : listNotTaken) {
        int nextMask = setBit(temp, second);
        int minDist = dp[mask] + getDist(0, 0, x[first], y[first]) + getDist(x[first], y[first], x[second], y[second]) + getDist(x[second], y[second], 0, 0);
        if (dp[nextMask] > minDist) {
          dp[nextMask] = minDist;
          parents[nextMask] = mask;
          brute(n, nextMask);
        }
      }
    }
  }

}






