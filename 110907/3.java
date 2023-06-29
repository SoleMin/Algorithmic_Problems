import java.io.*;
class Main {
    static int MAXN = 100;
    static int MAXE = 1000;
    static int MAXNAME = 32;
    static int MAXQUEUESIZE = 10000;

    static int n, e, ne, start, finish;
    static boolean reachable;
    static int[][] edges = new int[MAXE][4];
    static int[][] check = new int[MAXN][2];
    static String[] city = new String[MAXN];
    static int front, rear;
    static int[] queue = new int[MAXQUEUESIZE];
    static BufferedReader br;

    static int getcity(String name) {
        for(int i = 0; i < n; i++) {
            if(name.equals(city[i]))
                return i;
        }
        city[n] = name;
        return n++;
    }
    static void input() throws Exception{
        String name1 = "", name2 = "";
        int t1, t2;
        n = ne = 0;
        int e = Integer.parseInt(br.readLine());
        for(int i = 0; i < e; i++) {
            String[] str = br.readLine().split(" ");
            name1 = str[0];
            name2 = str[1];
            t1 = Integer.parseInt(str[2]);
            t2 = Integer.parseInt(str[3]);

            t1 %= 24;
            if((t1 >= 6 && t1 < 18) || (t1 < 6 && t2 > 6 - t1) || (t1 >= 18 && t2 > 30 - t1))
                continue;
            edges[ne][0] = getcity(name1);
            edges[ne][1] = getcity(name2);
            edges[ne][2] = (t1 + 12) % 24;
            edges[ne][3] = t2;
            ne++;
        }
        String[] str = br.readLine().split(" ");
        start = getcity(str[0]);
        finish = getcity(str[1]);
    }
    static void bfs() {
        int[] now = new int[3];
        front = 0;
        rear = 0;
        reachable = false;

        for(int i = 0; i < n; i++)
            check[i][0] = 10000;
        queue[rear++] = start;
        check[start][0] = 0;
        check[start][1] = 0;
        while(front < rear) {
            now[0] = queue[front++];
            now[1] = check[now[0]][0];
            now[2] = check[now[0]][1];
            if(now[0] == finish) {
                reachable = true;
                continue;
            }
            for(int i = 0; i < ne; i++) {
                if(edges[i][0] != now[0]) continue;
                if(now[2] <= edges[i][2] && (check[edges[i][1]][0] > now[1] || (check[edges[i][1]][0] == now[1] && check[edges[i][1]][1] >edges[i][2] + edges[i][3]))) {
                    queue[rear++] = edges[i][1];
                    check[edges[i][1]][0] = now[1];
                    check[edges[i][1]][1] = edges[i][2] + edges[i][3];
                }
                else if(check[edges[i][1]][0] > now[1]+1 || (check[edges[i][1]][0] == now[1]+1 && check[edges[i][1]][1] > edges[i][2] + edges[i][3])){
                    queue[rear++] = edges[i][1];
                    check[edges[i][1]][0] = now[1]+1;
                    check[edges[i][1]][1] = edges[i][2] + edges[i][3];
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int tc = Integer.parseInt(input);
        for(int i = 1; i <= tc; i++) {
            input();
            bfs();
            System.out.println("Test Case " + i +".");
            if(reachable)
                System.out.println("Vladimir needs " + check[finish][0] + " litre(s) of blood.");
            else
                System.out.println("There is no route Vladimir can take.");
        }
    }
}