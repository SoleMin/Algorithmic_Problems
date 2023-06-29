import java.io.*;
class Main {
    static int MAXN = 200;
    static int n, graph[][] = new int[MAXN][MAXN];
    static int[] color = new int[MAXN];
    static boolean colorable;
    static BufferedReader br;

    static boolean input() throws Exception{
        String input = br.readLine();
        n = Integer.parseInt(input);
        if(n == 0)
            return false;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++)
                graph[i][j] = 0;
        }
        input = br.readLine();
        int l = Integer.parseInt(input);
        int a,b;
        for(int i = 0; i < l; i++) {
            input = br.readLine();
            a = Integer.parseInt(input.split(" ")[0]);
            b = Integer.parseInt(input.split(" ")[1]);

            graph[a][b] = graph[b][a] = 1;
        }
        return true;
    }

    static void dfs(int node, int c) {
        color[node] = c;
        for(int i = 0; i < n && colorable; i++) {
            if(graph[node][i] == 0)
                continue;
            if(color[i] == 0)
                dfs(i, c % 2 + 1);
            else {
                if(color[i] == c) {
                    colorable = false;
                    return;
                }
            }

        }
    }
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        while(input()) {
            for(int i = 0; i < n; i++)
                color[i] = 0;
            colorable = true;
            dfs(0, 1);

            if(colorable)
                System.out.println("BICOLORABLE.");
            else
                System.out.println("NOT BICOLORABLE.");
        }
    }
}