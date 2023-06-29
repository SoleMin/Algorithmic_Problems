
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main
{
    static final int MAXN = 200;
    static int n;
    static int graph[][];
    static int color[];
    static boolean colorable;
    static String buf;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer token;

    public static boolean input() throws IOException {
        int i, j, l, a, b;
        buf = br.readLine();
        n = Integer.parseInt(buf);
        if (n == 0) return false;
        for (i = 0; i < n; i++)
            for (j = 0; j < n; j++)
                graph[i][j] =0;
        buf = br.readLine();
        l = Integer.parseInt(buf);
        for (i = 0; i < l; i++)
        {
            buf = br.readLine();
            token = new StringTokenizer(buf, " ");
            a = Integer.parseInt(token.nextToken());
            b = Integer.parseInt(token.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }
        return true;
    }
    public static void dfs(int node, int c)
    {
        int i;
        color[node] = c;
        for (i = 0; i < n && colorable; i++){
            if (graph[node][i] == 0)continue;
            if (color[i] == 0)
                dfs(i, c%2 + 1);
            else{
                if (color[i] ==c)
                {
                    colorable = false;
                    return;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        int i;
        graph= new int[MAXN][MAXN];
        color= new int [MAXN];
        while(input()) {
            for (i = 0; i < n; i++)
                color[i] = 0;
            colorable = true;
            dfs(0, 1);

            if (colorable == false)
                System.out.println("NOT BICOLORABLE.");
            else
                System.out.println("BICOLORABLE.");
        }
    }

}

