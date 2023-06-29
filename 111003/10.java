
import java.util.*;

class Main {
    static Scanner sc = new Scanner(System.in);
    static final int inf = 9999999;
    static int[] F_pos;
    static int[][] Dis;

    public static void initialize(int N) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++)
                Dis[i][j] = inf;
            Dis[i][i] = 0;
        }
    }

    public static void floyd(int N) {
        for (int k = 1; k <= N; k++)
            for (int i = 1; i <= N; i++)
                for (int j = 1; j <= N; j++)
                    if (Dis[i][k] + Dis[k][j] < Dis[i][j])
                        Dis[i][j] = Dis[i][k] + Dis[k][j];
    }

    public static void main(String[] args) {
        int testCase, num_fs, num_is;
        testCase = sc.nextInt();
        for (int t = 0; t < testCase; t++) {
            F_pos = new int[101];
            Dis = new int[501][501];
            num_fs = sc.nextInt();
            num_is = sc.nextInt();
            for (int i = 0; i < num_fs; i++)
                F_pos[i] = sc.nextInt();
            initialize(num_is);
            for (int i = 0; i < num_is; i++) {
                int x, y, l;
                x = sc.nextInt();
                y = sc.nextInt();
                l = sc.nextInt();
                Dis[x][y] = l;
                Dis[y][x] = l;
            }
            floyd(num_is);
            int[] s_l = new int[501];
            int max_s_l = 0;
            for (int i = 1; i <= num_is; i++) {
                s_l[i] = inf;
                for (int j = 0; j < num_fs; j++)
                    s_l[i] = Math.min(s_l[i], Dis[i][F_pos[j]]);
                max_s_l = Math.max(max_s_l, s_l[i]);
            }

            int answer = 1;
            boolean hasIt = false;
            for (int i = 1; i <= num_is; i++) {
                int [] copy = new int [num_is + 1];
                int max= -1;
                for (int j = 0; j <num_fs; j++)
                    if (F_pos[j] == i) {
                        hasIt = true; break;
                    }
                if (hasIt == true){
                    hasIt = false;
                    continue;
                }
                for (int j = 0; j <= num_is; j++)
                    copy[j] = s_l[j];
                for (int j = 1; j <= num_is; j++) {
                    copy[j] = Math.min(copy[j], Dis[j][i]);
                    max = Math.max(max, copy[j]);
                }
                if (max < max_s_l)
                {
                    answer = i;
                    max_s_l = max;
                }


            }
            System.out.println(answer);
            if (t != testCase - 1)
                System.out.println();

        }
    }
}