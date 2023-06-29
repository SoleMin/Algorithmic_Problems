import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/** Created by huhansan on 2017/10/9. */
public class CF_8C implements Runnable {
  int[] step = new int[1 << 24]; //每个状态所需要的步数
  int[] steplast = new int[1 << 24]; //当前状态上一个
  int n;
  int vs[] = new int[24];
  int vd[][] = new int[24][24];
  int x_bag, y_bag;
  int x[] = new int[24], y[] = new int[24];
  /** */
  private void solve() throws IOException {
    x_bag = nextInt();
    y_bag = nextInt();
    n = nextInt();
    for (int i = 0; i < n; i++) {
      x[i] = nextInt();
      y[i] = nextInt();
    }

    //计算所有物品单取的全值和 任意两件物品一起取的权值
    for (int i = 0; i < n; i++) {
      vs[i] = 2 * ((x[i] - x_bag) * (x[i] - x_bag) + (y[i] - y_bag) * (y[i] - y_bag));
    }
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        vd[i][j] =
            (x[i] - x_bag) * (x[i] - x_bag)
                + (y[i] - y_bag) * (y[i] - y_bag)
                + (x[j] - x_bag) * (x[j] - x_bag)
                + (y[j] - y_bag) * (y[j] - y_bag)
                + (x[i] - x[j]) * (x[i] - x[j])
                + (y[i] - y[j]) * (y[i] - y[j]);
      }
    }

    //记录达到每一个状态所需的最小步数和最后一次取得物品
    for (int i = 1; i < 1 << n; i++) {
      int j, k = 0, l, m, lastState;
      for (j = 1; (i & j) == 0 && j < 1 << n; j <<= 1) {
        k++;
      }
      lastState = i & (~j);
      step[i] = step[lastState] + vs[k];
      steplast[i] = lastState;
      m = k;
      for (l = j << 1; l < 1 << n; l <<= 1) {
        m++;
        if ((lastState & l) != 0) {
          if (step[i] > step[lastState & (~l)] + vd[k][m]) {
            step[i] = step[lastState & (~l)] + vd[k][m];
            steplast[i] = lastState & (~l);
          }
        }
      }
      //      System.out.println(steplast[i]+"---"+i+"---"+step[i]);
    }
    writer.println(step[(1 << n) - 1]);
    int i = (1 << n) - 1;
    writer.print("0 ");
    while (i != 0) {
      for (int j = 1, m = 1; j <= i; j <<= 1, m++) {
        if ((j & (i ^ steplast[i])) != 0) {
          writer.print(m + " ");
        }
      }
      writer.print("0 ");
      i = steplast[i];
    }
  }

  public static void main(String[] args) {
    new CF_8C().run();
  }

  BufferedReader reader;
  StringTokenizer tokenizer;
  PrintWriter writer;

  public void run() {
    try {
      reader = new BufferedReader(new InputStreamReader(System.in));
      tokenizer = null;
      writer = new PrintWriter(System.out);
      solve();
      reader.close();
      writer.close();
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
  }

  int nextInt() throws IOException {
    return Integer.parseInt(nextToken());
  }

  long nextLong() throws IOException {
    return Long.parseLong(nextToken());
  }

  double nextDouble() throws IOException {
    return Double.parseDouble(nextToken());
  }

  String nextToken() throws IOException {
    while (tokenizer == null || !tokenizer.hasMoreTokens()) {
      tokenizer = new StringTokenizer(reader.readLine());
    }
    return tokenizer.nextToken();
  }
}
