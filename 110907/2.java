import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {
	 static int MAXN =100;
    static int MAXE = 1000;
    static int MAXNAME = 32;

    static int n,e,ne,start,finish,reachable;
    static int[][] edges = new int[MAXE][4];
    static int[][] check = new int[MAXN][2];
    static String[] city= new String[MAXNAME+1];
    static Queue<Integer> queue = new LinkedList();
    static BufferedReader br;

    public static int getcity(String name) {
        int i;
        for (i = 0; i < n; i++) {
            if (name.equals(city[i])) return i;
        }
        city[n] = name;
        return n++;
    }
    public static void input() throws IOException {
        String name1 = "", name2="";
        int t1 = 0,t2 =0;
        n = ne = 0;
        String input = br.readLine();
        e = Integer.parseInt(input);
        for(int i =0;i<e;i++) {
            input = br.readLine();
            name1 = input.split(" ")[0];
            name2 = input.split(" ")[1];
            t1 = Integer.parseInt(input.split(" ")[2]);
            t2 = Integer.parseInt(input.split(" ")[3]);
            t1 %= 24;

            if ((t1 >= 6 && t1 < 18) || (t1 < 6 && t2 > 6 - t1) || (t1 >= 18 && t2 > 30 - t1))
                continue;

            edges[ne][0] = getcity(name1);
            edges[ne][1] = getcity(name2);
            edges[ne][2] = (t1 + 12) % 24;
            edges[ne][3] = t2;
            ne++;
        }
        input= br.readLine();
        start = getcity(input.split(" ")[0]);
        finish = getcity(input.split(" ")[1]);
    }

    public static void bfs() {
        int[] now = new int[3];
        reachable = 0;

        for (int i = 0; i < n; i++)
            check[i][0] = 10000;
        queue.offer(start);
        check[start][0] = 0;
        check[start][1] = 0;
        while (!queue.isEmpty()) {
            now[0] = queue.poll();
            now[1] = check[now[0]][0];
            now[2] = check[now[0]][1];
            if (now[0] == finish) {
                reachable = 1;
                continue;
            }
            for (int i = 0; i < ne; i++) {
                if (edges[i][0] != now[0]) continue;
                if (now[2] <= edges[i][2] && // 출발 시각 확인
                        (check[edges[i][1]][0] > now[1] || // 누적 날짜 확인
                                (check[edges[i][1]][0] == now[1] &&
                                        check[edges[i][1]][1] > edges[i][2] + edges[i][3]))) { // 도착 시각 확인
                    queue.offer(edges[i][1]); // 더 짧은 경로 설정
                    check[edges[i][1]][0] = now[1];
                    check[edges[i][1]][1] = edges[i][2] + edges[i][3];
                }
            else if(  check[edges[i][1]][0] > now[1]+1 ||
                        (check[edges[i][1]][0] == now[1]+1 &&
                                check[edges[i][1]][1] > edges[i][2] + edges[i][3])){
                    queue.offer(edges[i][1]); // 더 짧은 경로 설정
                    check[edges[i][1]][0] = now[1]+1;
                    check[edges[i][1]][1] = edges[i][2] + edges[i][3];
                }
            }

        }
    }

	public static void main(String[] args) throws Exception {
	  br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i =1;i<= t;i++){
            input();
            bfs();

            System.out.printf("Test Case %d.\n",i);
            if(reachable==1)
                System.out.printf("Vladimir needs %d litre(s) of blood.\n", check[finish][0]);
            else
                System.out.printf("There is no route Vladimir can take.\n");
        }
	}
}