
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
    static final int MAXN = 100;
    static final int MAXE = 1000;
    static String[] city;
    static int[][] edges;
    static int[][] check;
    static int n, e, ne, start, finish;
    static boolean reachable;
    static Queue<Integer> queue = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int i, t;
        t = sc.nextInt();
        for (i = 1; i <= t; i++) {
            edges = new int[MAXE][4];
            check = new int[MAXN][2];
            city = new String[MAXN];
            input();
            bfs();

            System.out.println("Test Case " + i + ".");
            if (reachable)
                System.out.println("Vladimir needs " + check[finish][0] + " litre(s) of blood.");
            else
                System.out.println("There is no route Vladimir can take.");

        }
    }

    public static void input() {
        int i, t1, t2;
        String name1, name2;
        n = ne = 0;
        e = sc.nextInt();
        for (i = 0; i < e; i++) {
            name1 = sc.next();
            name2 = sc.next();
            t1 = sc.nextInt();
            t2 = sc.nextInt();

            t1 %= 24;

            if ((t1 >= 6 && t1 < 18) || (t1 < 6 && t2 > 6 - t1) || (t1 >= 18 && t2 > 30 - t1))
                continue;
            edges[ne][0] = getcity(name1);
            edges[ne][1] = getcity(name2);
            edges[ne][2] = (t1 + 12) % 24;
            edges[ne][3] = t2;
            ne++;
        }
        name1 = sc.next();
        name2 = sc.next();
        start = getcity(name1);
        finish = getcity(name2);
    }

    public static int getcity(String name) {
        int i;
        for (i = 0; i < n; i++)
            if (name.compareTo(city[i]) == 0)
                return i;
        city[n] = name;
        return n++;
    }

    public static void bfs() {
        int i, t;
        int[] now = new int[3];
        reachable = false;
        queue.clear();
        queue.add(start);
        for ( i = 0; i < n; i++)
            check[i][0] = 99999;
        check[start][0] = 0;
        check[start][1] = 0;
        while (!queue.isEmpty()) {
            now[0] = queue.remove();
            now[1] = check[now[0]][0];
            now[2] = check[now[0]][1];
            if (now[0] == finish) {
                reachable = true;
                continue;
            }
            for (i = 0; i < ne; i++) {
                if (edges[i][0] != now[0]) continue;
                if (now[2] <= edges[i][2] && (check[edges[i][1]][0] > now[1] || (now[1] == check[edges[i][1]][0] && check[edges[i][1]][1] > edges[i][2] + edges[i][3]))) {
                    queue.add(edges[i][1]);
                    check[edges[i][1]][0] = now[1];
                    check[edges[i][1]][1] = edges[i][2] + edges[i][3];
                } else if (now[1] + 1 < check[edges[i][1]][0] || (now[1] + 1 == check[edges[i][1]][0] && check[edges[i][1]][1] > edges[i][2] + edges[i][3])) {
                    queue.add(edges[i][1]);
                    check[edges[i][1]][0] = now[1] + 1;
                    check[edges[i][1]][1] = edges[i][2] + edges[i][3];
                }

            }
        }

    }
}