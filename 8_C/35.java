import java.util.Scanner;

public class Problem_8C {
  private static int dis(int x1, int y1, int x2, int y2) {
    return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int ox = sc.nextInt();
    int oy = sc.nextInt();
    int n = sc.nextInt();
    int[] ix = new int[n];
    int[] iy = new int[n];
    int[] single = new int[n];
    int[][] pair = new int[n][n];
    for (int i = 0; i < n; i++) {
      ix[i] = sc.nextInt();
      iy[i] = sc.nextInt();
      single[i] = dis(ox, oy, ix[i], iy[i]) * 2;
      for (int j = 0; j < i; j++) {
        pair[i][j] = pair[j][i] = dis(ix[i], iy[i], ix[j], iy[j]) + (single[i] + single[j]) / 2;
      }
    }
    int[] min = new int[1 << n];
    int[] pre = new int[1 << n];
    for (int set = 1; set < 1 << n; set++) {
      int i;
      for (i = 0; i < n; i++) {
        if ((set & (1 << i)) != 0) {
          break;
        }
      }
      min[set] = min[set ^ (1 << i)] + single[i];
      pre[set] = set ^ (1 << i);
      for (int j = 0; j < n; j++) {
        if ((set & (1 << j)) == 0) {
          continue;
        }
        if (min[set] > min[set ^ (1 << i) ^ (1 << j)] + pair[i][j]) {
          min[set] = min[set ^ (1 << i) ^ (1 << j)] + pair[i][j];
          pre[set] = set ^ (1 << i) ^ (1 << j);
        }
      }
    }
    System.out.println(min[(1 << n) - 1]);
    for (int set = (1 << n) - 1; set != 0; set = pre[set]) {
      System.out.print("0 ");
      for (int i = 0; i < n; i++) {
        if (((set ^ pre[set]) & (1 << i)) != 0) {
          System.out.print((i + 1) + " ");
        }
      }
    }
    System.out.println("0");
    sc.close();
  }
}
