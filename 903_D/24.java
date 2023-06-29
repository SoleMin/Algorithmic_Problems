import java.math.BigInteger;
import java.util.*;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class D {
  public static void main(String[] args) {
    init();

    int n = in.nextInt();

    long total = 0L;



    int arr[] = new int[n+5];

    Map<Integer, Integer> freq = new HashMap<>();
    Map<Integer, Integer> kiri = new HashMap<>();

    for (int i = 1; i <= n; ++i){
     arr[i] = in.nextInt();
      if (freq.containsKey(arr[i])) {
        freq.put(arr[i], freq.get(arr[i])+1);
      } else {
        freq.put(arr[i], 1);
        kiri.put(arr[i], 0);
      }
      total += (long)arr[i];
    }

    BigInteger ans = BigInteger.valueOf(0L);

    for (int i = 1; i <= n - 1; ++i) {
      kiri.put(arr[i], kiri.get(arr[i])+1);
      total -= arr[i];

      int cnt_kanan = n - i;
      long temp = total;
      int cnt_sama = freq.get(arr[i]) - kiri.get(arr[i]);
      temp -= (cnt_sama)*(long)arr[i];
      cnt_kanan -= (cnt_sama);
      if (freq.containsKey(arr[i]-1)) {
        int cnt_kurang = freq.get(arr[i]-1) - kiri.get(arr[i]-1);
        cnt_kanan -= cnt_kurang;
        temp -= (long) cnt_kurang * (long)(arr[i]-1);
      }
      if (freq.containsKey(arr[i]+1)) {
        int cnt_lebih = freq.get(arr[i]+1) - kiri.get(arr[i]+1);
        cnt_kanan -= cnt_lebih;
        temp -= (long)(cnt_lebih) * (long)(arr[i]+1);
      }
      temp -= (long)cnt_kanan * (long)arr[i];
      ans = ans.add(BigInteger.valueOf(temp));
    }

    out.println(ans.toString());
    out.close();
  }

  /* PrintWriter and BufferedReader Template from Codeforces */
  public static MyScanner in;
  public static PrintWriter out;

  public static void init() {
    in = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
  }

  public static class MyScanner {
    BufferedReader br;
    StringTokenizer st;

    MyScanner() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }

    String nextLine() {
      String str = "";
      try {
        str = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }
  }

}