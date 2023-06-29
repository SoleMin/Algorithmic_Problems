import java.io.*;
class Main {
    static BufferedReader br;
    static int MAXN = 100;
    static int n;
    static int[] check = new int[MAXN];
    static double[][] dot = new double[MAXN][2];
    static double[] minval = new double[MAXN];
    static double result;

    static void input() throws Exception{
        String input = br.readLine();
        n = Integer.parseInt(input);
        for(int i = 0; i < n; i++) {
            input = br.readLine();
            String tmp[] = input.split(" ");
            dot[i][0] = Double.parseDouble(tmp[0]);
            dot[i][1] = Double.parseDouble(tmp[1]);
        }
    }

    static double dist(int a, int b) {
        return Math.sqrt(Math.pow(dot[a][0] - dot[b][0], 2) + Math.pow(dot[a][1] - dot[b][1], 2));
    }
    static void solve() {
        result = 0;
        for(int i = 0; i < n; i++) {
            check[i] = 0;
        }
        check[0] = 1;
        for(int i = 1; i < n; i++) {
            minval[i] = dist(0, i);
        }
        for(int i = 0; i < n - 1; i++) {
            int idx = -1;
            for(int j = 0; j < n; j++) {
                if(check[j] == 1)
                    continue;
                if(idx == -1 || minval[idx] > minval[j])
                    idx = j;
            }
            result += minval[idx];
            check[idx] = 1;
            for(int j = 0; j < n; j++) {
                if(check[j] == 1)
                    continue;
                double dist = dist(idx, j);
                if(minval[j] > dist)
                    minval[j] = dist;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int i = 0; i < tc; i++) {
            br.readLine();
            input();
            solve();
            if(i > 0)
                System.out.println();
            System.out.printf("%.2f\n", result);
        }
    }
}