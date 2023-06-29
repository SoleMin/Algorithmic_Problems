import java.util.Scanner;

public class Main {

    static int maxN = 200;
    static int vertex_num;
    static int[][] graph = new int[maxN][maxN];
    static int[] color = new int[maxN];
    static boolean colorable;

    static void dfs(int node, int c){
        color[node] = c;
        for (int i = 0; i < vertex_num && colorable; i++){
            if (graph[node][i] == 0)
                continue;
            if (color[i] == 0)
                dfs(i, c % 2 + 1);
            else {
                if (color[i] == c){
                    colorable = false;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        while (scan.hasNextLine()) {
            vertex_num = scan.nextInt();

            if (vertex_num == 0)
                break;

            for (int i = 0; i < vertex_num; i++){
                for (int j = 0; j < vertex_num; j++){
                    graph[i][j] = 0;
                }
            }

            int edge_num = scan.nextInt();

            for (int edge = 0; edge < edge_num; edge++) {
                int a = scan.nextInt();
                int b = scan.nextInt();
                graph[a][b] = graph[b][a] = 1;
                scan.nextLine();
            }
            for (int i = 0; i < vertex_num; i++){
                color[i] = 0;
            }
            colorable = true;

            dfs(0, 1);

            if (!colorable)
                System.out.println("NOT BICOLORABLE.");
            else
                System.out.println("BICOLORABLE.");
        }
    }
}