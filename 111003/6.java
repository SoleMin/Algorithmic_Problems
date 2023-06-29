import java.io.*;
class Main {
    static int Inf = 9999999;
    static int[] F_pos = new int[101];
    static int[][] Dis = new int[501][501];

    static void init(int N) {
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++)
                Dis[i][j] = Inf;
            Dis[i][i] = 0;
        }
    }
    static void floyd(int N) {
        for(int k = 1; k <= N; k++)
            for(int i = 1; i <= N; i++)
                for(int j = 1; j <= N; j++)
                    if(Dis[i][k] + Dis[k][j] < Dis[i][j])
                        Dis[i][j] = Dis[i][k] + Dis[k][j];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int testCase = Integer.parseInt(input);
        int num_fs, num_is;
        br.readLine();
        for(int tc = 0; tc < testCase; tc++) {
            String[] tmp = br.readLine().split(" ");
            num_fs = Integer.parseInt(tmp[0]);
            num_is = Integer.parseInt(tmp[1]);
            for(int i = 0; i < num_fs; i++) {
                String f = br.readLine();
                F_pos[i] = Integer.parseInt(f);
            }
            init(num_is);

            String str = br.readLine();
            while(str != null && str.length() != 0) {
                tmp = str.split(" ");
                int x = Integer.parseInt(tmp[0]);
                int y = Integer.parseInt(tmp[1]);
                int L = Integer.parseInt(tmp[2]);
                Dis[x][y] = L;
                Dis[y][x] = L;
                str = br.readLine();
            }
            floyd(num_is);

            int[] s_l = new int[501];
            int max_s_l = 0;
            for(int i = 1; i <= num_is; i++) {
                s_l[i] = Inf;
                for(int j = 0; j < num_fs; j++)
                    s_l[i] = Math.min(s_l[i], Dis[i][F_pos[j]]);
                max_s_l = Math.max(max_s_l, s_l[i]);
            }
            int Ans = 1;
            for(int i = 1; i <= num_is; i++) {
                int length = 0;
                for(int j = 1; j <= num_is; j++) {
                    int min = Math.min(Dis[i][j], s_l[j]);
                    length = Math.max(length, min);
                }
                if(length < max_s_l) {
                    max_s_l = length;
                    Ans = i;
                }
            }
            System.out.println(Ans);
					System.out.println();
        }
    }
}